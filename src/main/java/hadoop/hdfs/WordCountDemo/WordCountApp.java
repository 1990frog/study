package hadoop.hdfs.WordCountDemo;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * 使用HDFS API完成wordcount统计
 *
 * 需求：统计HDFS上的文件的wc，然后讲统计的结果输出到HDFS
 *
 * 功能拆解：
 * 1）读取HDFS上的文件 ==> HDFS API
 * 2）业务处理（词频统计）：对文件中的每一行数据都要进行业务处理（按照分隔符分割）==> Mapper
 * 3）将处理结果缓存起来 ==> Context
 * 4）将结果输出到HDFS ==> HDFS API
 */
public class WordCountApp {

	public static void main(String[] args) throws Exception{

		Properties properties = ParamsUtils.getProperties();

		//1）读取HDFS上的文件 ==> HDFS API
		Path input = new Path(properties.getProperty(Constants.INPUT_PATH));

		//获取要操作的HDFS文件系统
		FileSystem fs = FileSystem.get(new URI(properties.getProperty(Constants.HDFS_URI)),new Configuration());
		RemoteIterator<LocatedFileStatus> iterator = fs.listFiles(input, false);

//		Mapper mapper = new WordCountMapper();
		Class clazz = Class.forName(properties.getProperty(Constants.MAPPER_CLASS));
		Mapper mapper = (Mapper)clazz.newInstance();
		Context context = new Context();

		while (iterator.hasNext()){
			LocatedFileStatus file = iterator.next();
			FSDataInputStream in = fs.open(file.getPath());
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));

			String line;
			while ((line = reader.readLine())!=null){
				//2）业务处理（词频统计）
				mapper.map(line,context);
			}

			reader.close();
			in.close();

		}

		//3）将处理结果缓存起来

		Map<Object,Object> contextMap = context.getCacheMap();

		//4）将结果输出到HDFS ==> HDFS API
		Path output = new Path(properties.getProperty(Constants.OUTPUT_PATH));

		FSDataOutputStream out = fs.create(new Path(output,new Path(properties.getProperty(Constants.OUTPUT_FILE))));

		// 将第三步缓存中的内容输出到out中去
		Set<Map.Entry<Object,Object>> entries = contextMap.entrySet();
		for(Map.Entry<Object,Object> entry : entries){
			out.write((entry.getKey()+"\t"+entry.getValue()+"\n").getBytes());
		}

		out.close();
		fs.close();

		System.out.println("运行成功");
	}

}
