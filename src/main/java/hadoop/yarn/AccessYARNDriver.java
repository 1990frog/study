package hadoop.yarn;

import hadoop.mapreduce.access.Access;
import hadoop.mapreduce.access.AccessMapper;
import hadoop.mapreduce.access.AccessPartitioner;
import hadoop.mapreduce.access.AccessReducer;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;


/**
 * jar run
 * hadoop jar thisjar hadoop.yarn.AccessYARNDriver /input.log /output.log
 *
 */
public class AccessYARNDriver {

	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {

		Configuration configuration = new Configuration();

		//  创建一个Job
		Job job = Job.getInstance(configuration);

		//  设置Job对应的参数：主类
		job.setJarByClass(AccessYARNDriver.class);

		//  设置Job对应的参数：设置自定义的Mapper和Reduce处理类
		job.setMapperClass(AccessMapper.class);
		job.setReducerClass(AccessReducer.class);

		//  设置自定义分区规则
		job.setPartitionerClass(AccessPartitioner.class);
		//  设置分区数
		job.setNumReduceTasks(3);

		//  设置Job对应的参数：Mapper输出key和value的类型
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(Access.class);

		//  设置Job对应的参数：Reducer输出key和value的类型
		job.setOutputKeyClass(NullWritable.class);
		job.setOutputValueClass(Access.class);

		//  设置job对应的参数：Mapper输出key和value的类型：作业输入和输出的路径
		FileInputFormat.setInputPaths(job,new Path(args[0]));
		FileOutputFormat.setOutputPath(job,new Path(args[1]));

		//  提交job
		boolean result = job.waitForCompletion(true);

		System.exit(result ? 0 : -1);
	}
}
