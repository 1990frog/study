package hdfs.wordcountdemo;

import java.io.IOException;
import java.util.Properties;

/**
 * The type Params utils.
 */
public class ParamsUtils {

	private static Properties properties = new Properties();

	static {
		try {
			properties.load(ParamsUtils.class.getClassLoader().getResourceAsStream("wordcount.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

    /**
     * Get properties properties.
     *
     * @return the properties
     */
    public static Properties getProperties(){
		return properties;
	}

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
		System.out.println(getProperties().getProperty("INPUT_PATH"));
	}

}
