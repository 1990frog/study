package hadoop.mapreduce.wordcount;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * 使用MR统计HDFS上的文件对应的词频
 * <p>
 * Driver：配置Mapper、Reducer的相关属性
 * <p>
 * 提交到本地运行：开发过程中使用
 */
public class WordCountApp {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     * @throws IOException            the io exception
     * @throws ClassNotFoundException the class not found exception
     * @throws InterruptedException   the interrupted exception
     * @throws URISyntaxException     the uri syntax exception
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException, URISyntaxException {

		System.setProperty("HADOOP_USER_NAME","cai");

		Configuration configuration = new Configuration();
		configuration.set("fs.defaultFS","hdfs://localhost:8020");

		//  创建一个Job
		Job job = Job.getInstance(configuration);

		//  设置Job对应的参数：主类
		job.setJarByClass(WordCountApp.class);

		//  设置Job对应的参数：设置自定义的Mapper和Reduce处理类
		job.setMapperClass(WordCountMapper.class);
		job.setReducerClass(WordCountReducer.class);

		//  设置Job对应的参数：Mapper输出key和value的类型
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(IntWritable.class);

		//  设置Job对应的参数：Reducer输出key和value的类型
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);

		//  如果输出目录已经存在，则先删除
		FileSystem fileSystem = FileSystem.get(new URI("hdfs://localhost:8020"),configuration);
		Path outputPath = new Path("/wordcount/output");
		if(fileSystem.exists(outputPath)){
			fileSystem.delete(outputPath,true);
		}

		//  设置job对应的参数：Mapper输出key和value的类型：作业输入和输出的路径
		FileInputFormat.setInputPaths(job,new Path("/wordcount/input"));
		FileOutputFormat.setOutputPath(job,new Path("/wordcount/output"));

		//  提交job
		boolean result = job.waitForCompletion(true);

		System.exit(result ? 0 : -1);
	}
}
