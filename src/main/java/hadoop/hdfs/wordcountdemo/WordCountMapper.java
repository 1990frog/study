package hadoop.hdfs.wordcountdemo;

/**
 * 自定义wc实现类
 */
public class WordCountMapper implements Mapper {

	@Override
	public void map(String line, Context context) {

		String[] words = line.split("\t");

		for(String word : words){
			Object value = context.get(word);
			if(value == null){
				context.write(word,1);
			}else{
				int v = Integer.parseInt(value+"");
				context.write(word,v+1);
			}
		}
	}
}
