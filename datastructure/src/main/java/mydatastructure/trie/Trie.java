package mydatastructure.trie;

import java.util.Map;
import java.util.TreeMap;

public class Trie {

    private int size;
    private Node root;

    private final class Node{
        public boolean isWord;
        public TreeMap<Character,Node> next;

        public Node(boolean isWord){
            this.isWord = isWord;
            next = new TreeMap<>();
        }

        public Node(){
            this(false);
        }
    }

    public Trie(){
        root = new Node();
        size = 0;
    }

    public int getSize(){
        return size;
    }

    public void add(String word){
        Node cur = root;
        for(char c:word.toCharArray()){
            if(cur.next.get(c)==null)
                cur.next.put(c,new Node());
            cur = cur.next.get(c);
        }
        if(!cur.isWord){
            cur.isWord = true;
            size ++;
        }
    }

    public boolean contains(String word){
        Node cur = root;
        for(char c:word.toCharArray()){
            if(cur.next.get(c)==null)
                return false;
            cur = cur.next.get(c);
        }
        return cur.isWord;
    }

    // 查询是否在Trie中有单词以prefix为前缀
    public boolean isPrefix(String prefix){

        Node cur = root;
        for(int i = 0 ; i < prefix.length() ; i ++){
            char c = prefix.charAt(i);
            if(cur.next.get(c) == null)
                return false;
            cur = cur.next.get(c);
        }

        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.add("hello");
        trie.add("hallo");
        System.out.println(trie.contains("hello"));
    }
}
