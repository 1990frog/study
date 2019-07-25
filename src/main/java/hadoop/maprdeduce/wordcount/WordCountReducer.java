package hadoop.maprdeduce.wordcount;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.Iterator;

/**
 * The type Word count reducer.
 *
 * Reducer<KEYIN,VALUEIN,KEYOUT,VALUEOUT>
 *
 */
public class WordCountReducer extends Reducer <Text, IntWritable, Text, IntWritable>{

	/**
	 *(hello,1) (world,1)
	 *(hello,1) (world,1)
	 *(hello,1) (world,1)
	 * (welcome,1)
	 *
	 * map的输出到reduce端，是按照相同的key分发到一个reduce上去执行
	 *
	 * reduce1: (hello,1) (hello,1) (hello,1) ==> (hello,<1,1,1>)
	 * reduce2: (world,1) (world,1) (world,1)==> (world,<1,1,1>)
	 * reduce3:(welcome,1)==> (welcome,<1>)
	 *
	 * Reducer和Mapper中使用模板设计模式
     *
	 */
	@Override
    protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {

		int count = 0;

		//<1,1,1>)
		Iterator<IntWritable> iterable = values.iterator();
		while (iterable.hasNext()){
			IntWritable value = iterable.next();
			count += value.get();
		}

		context.write(key,new IntWritable(count));
	}
}
