package mapreduce.wordcount;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

/**
 * Combiner操作
 * 优点：能减少IO、提升作业的执行性能
 * 局限性：求平均数（总数/个数）
 */
public class WordCountCombinerLocalApp {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     * @throws IOException            the io exception
     * @throws ClassNotFoundException the class not found exception
     * @throws InterruptedException   the interrupted exception
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {

//		System.setProperty("HADOOP_USER_NAME","cai");
//
		Configuration configuration = new Configuration();
//		configuration.set("fs.defaultFS","hdfs://localhost:8020");

		//  创建一个Job
		Job job = Job.getInstance(configuration);

		//  设置Job对应的参数：主类
		job.setJarByClass(WordCountCombinerLocalApp.class);

		//  设置Job对应的参数：设置自定义的Mapper和Reduce处理类
		job.setMapperClass(WordCountMapper.class);
		job.setReducerClass(WordCountReducer.class);

		//  添加Combiner的设置即可
		job.setCombinerClass(WordCountReducer.class);

		//  设置Job对应的参数：Mapper输出key和value的类型
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(IntWritable.class);

		//  设置Job对应的参数：Reducer输出key和value的类型
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);

		//  设置job对应的参数：Mapper输出key和value的类型：作业输入和输出的路径
		FileInputFormat.setInputPaths(job,new Path("input"));
		FileOutputFormat.setOutputPath(job,new Path("output"));

		//  提交job
		boolean result = job.waitForCompletion(true);

		System.exit(result ? 0 : -1);
	}
}
