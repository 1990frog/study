package hadoop.hdfs.wordcountdemo;

/**
 * 自定义Mapper
 */
public interface Mapper {

    /**
     * Map.
     *
     * @param line    读取到每一行数据
     * @param context 上下文/缓存
     */
    void map(String line,Context context);
}
