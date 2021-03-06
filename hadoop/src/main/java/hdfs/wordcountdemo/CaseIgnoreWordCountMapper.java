package hdfs.wordcountdemo;

/**
 * The type Case ignore word count mapper.
 */
public class CaseIgnoreWordCountMapper implements Mapper {

	@Override
	public void map(String line, Context context) {
		String[] words = line.toLowerCase().split("\t");

		for(String word : words) {
			Object value = context.get(word);
			if (value == null) {
				context.write(word, 1);
			} else {
				int v = Integer.parseInt(value + "");
				context.write(word, v + 1);
			}
		}
	}
}
