package test;

import trie.Trie;

import java.util.HashMap;

/**
 * <p>
 *
 * </p>
 *
 * @author cai
 * @since 2022/7/15
 */
public class HashMapTrie implements Trie {

    class Node{
        public boolean isWord;
        public HashMap<Character, Node> next;

        public Node(boolean isWord) {
            this.isWord = isWord;
            this.next = new HashMap<>();
        }

        public Node() {
            this(false);
        }
    }

    private Node root;
    private int size;

    public HashMapTrie(){
        root = new Node();
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void add(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(cur.next.get(c) == null){
                cur.next.put(c,new Node());
            }
            cur = cur.next.get(c);
        }
        if(cur!=null){
            cur.isWord = true;
            size++;
        }

    }

    @Override
    public boolean contains(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(cur.next.get(c)==null)
                return false;
            cur = cur.next.get(c);
        }
        return cur.isWord;
    }
}
