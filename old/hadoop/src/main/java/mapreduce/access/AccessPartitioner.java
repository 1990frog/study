package mapreduce.access;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

/**
 *
 * MapReduce自定义分区规则
 */
public class AccessPartitioner extends Partitioner<Text,Access> {

	/**
	 *
	 * @param phone 手机号
	 * @param access 统计结果
	 */
	@Override
	public int getPartition(Text phone, Access access, int numPartitions) {

		if(phone.toString().startsWith("13")){
			return 0;
		}else if(phone.toString().startsWith("15")){
			return 1;
		}else{
			return 2;
		}
	}
}
