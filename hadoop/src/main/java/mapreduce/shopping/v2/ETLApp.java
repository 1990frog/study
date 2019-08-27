package mapreduce.shopping.v2;

import hadoop.mapreduce.access.AccessLocalDriver;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class ETLApp {

	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
		Configuration configuration = new Configuration();

		//  创建一个Job
		Job job = Job.getInstance(configuration);

		//  设置Job对应的参数：主类
		job.setJarByClass(AccessLocalDriver.class);

		//  设置Job对应的参数：设置自定义的Mapper和Reduce处理类
		job.setMapperClass(MyMapper.class);

		//  设置Job对应的参数：Mapper输出key和value的类型
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(Text.class);

		//  设置job对应的参数：Mapper输出key和value的类型：作业输入和输出的路径
		FileInputFormat.setInputPaths(job,new Path("input"));
		FileOutputFormat.setOutputPath(job,new Path("output"));

		//  提交job
		job.waitForCompletion(true);
	}

	static class MyMapper extends Mapper<LongWritable, Text, NullWritable, Text> {

		@Override
		protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
			String log = value.toString();
			String ip = "ip";
			String country = "country";
			String province = "province";
			String city = "city";
			String url = "url";
			String time = "time";
			StringBuilder builder = new StringBuilder();
			builder.append(ip).append("\t")
					.append(country).append("\t")
					.append(province).append("\t")
					.append(city).append("\t")
					.append(url).append("\t")
					.append(time).append("\t");
			context.write(NullWritable.get(),new Text(builder.toString()));
		}
	}
}
