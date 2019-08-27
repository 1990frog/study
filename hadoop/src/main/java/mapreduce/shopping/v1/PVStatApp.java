package mapreduce.shopping.v1;

import hadoop.mapreduce.access.*;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class PVStatApp {

	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
		Configuration configuration = new Configuration();

		//  创建一个Job
		Job job = Job.getInstance(configuration);

		//  设置Job对应的参数：主类
		job.setJarByClass(AccessLocalDriver.class);

		//  设置Job对应的参数：设置自定义的Mapper和Reduce处理类
		job.setMapperClass(MyMapper.class);
		job.setReducerClass(MyReducer.class);

		//  设置Job对应的参数：Mapper输出key和value的类型
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(LongWritable.class);

		//  设置Job对应的参数：Reducer输出key和value的类型
		job.setOutputKeyClass(NullWritable.class);
		job.setOutputValueClass(LongWritable.class);

		//  设置job对应的参数：Mapper输出key和value的类型：作业输入和输出的路径
		FileInputFormat.setInputPaths(job,new Path("input"));
		FileOutputFormat.setOutputPath(job,new Path("output"));

		//  提交job
		job.waitForCompletion(true);
	}

	static class MyMapper extends Mapper<LongWritable, Text, Text, LongWritable>{

		private Text KEY = new Text("key");
		private LongWritable ONE = new LongWritable(1);

		@Override
		protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
			context.write(KEY,ONE);
		}
	}

	static class MyReducer extends Reducer<Text, LongWritable, NullWritable, LongWritable>{

		@Override
		protected void reduce(Text key, Iterable<LongWritable> values, Context context) throws IOException, InterruptedException {
			long count = 0;
			for(LongWritable value : values){
				count++;
			}
			context.write(NullWritable.get(),new LongWritable(count));
		}
	}
}
