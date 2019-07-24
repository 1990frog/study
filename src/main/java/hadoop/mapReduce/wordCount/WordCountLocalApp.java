package hadoop.mapReduce.wordCount;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

/**
 * 使用MR统计HDFS上的文件对应的词频
 * <p>
 * Driver：配置Mapper、Reducer的相关属性
 * <p>
 * 提交到本地运行：开发过程中使用
 */
public class WordCountLocalApp {

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
		job.setJarByClass(WordCountLocalApp.class);

		//  设置Job对应的参数：设置自定义的Mapper和Reduce处理类
		job.setMapperClass(WordCountMapper.class);
		job.setReducerClass(WordCountReducer.class);

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
