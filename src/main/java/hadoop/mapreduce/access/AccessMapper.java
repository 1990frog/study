package hadoop.mapreduce.access;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class AccessMapper extends Mapper<LongWritable, Text, Text, Access> {

	@Override
	protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

		String[] lines = value.toString().split("\t");
		String phone = lines[1];//取出手机号
		long up = Long.parseLong(lines[2]);//取出上行流量
		long down = Long.parseLong(lines[3]);//取出下行流量

		context.write(new Text(phone),new Access(phone,up,down));//suff操作

	}
}