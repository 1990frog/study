public interface Trie {

    int getSize();

    /**
     * 向Trie中添加一个新的单词word
     * @param word
     */
    void add(String word);

    /**
     * 查询单词word是否在Trie中
     * @param word
     * @return
     */
    boolean contains(String word);
}
