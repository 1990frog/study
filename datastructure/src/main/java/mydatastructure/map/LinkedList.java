package mydatastructure.map;

public class LinkedList<K,V> {

    private Node dummyHead;
    private int size;

    class Node<K,V>{

        private Node next;
        private K k;
        private V v;

        public Node(K k,V v){
            this.k = k;
            this.v = v;
        }
        public Node(K k,V v,Node next){
            this.k = k;
            this.v = v;
            this.next = next;
        }
    }

    public LinkedList(){
        dummyHead = new Node(null,null);
    }

    private void add(K k,V v){
        dummyHead.next = new Node(k,v,dummyHead.next);
        size++;
    }

    public boolean contain(K k){
        Node prev = dummyHead.next;
        while (prev!=null){
            if(prev.k.equals(k))
                return true;
            prev = prev.next;
        }
        return false;
    }

    public V remove(K k){
        Node prev = dummyHead.next;
        while (prev!=null){
            if(k.equals(prev.k)){
                Node ret = prev;
                prev.next = ret.next;
                size--;
                return (V) ret.v;
            }
            prev = prev.next;
        }
        return null;
    }

    public V get(K k){
        Node prev = dummyHead.next;
        while (prev!=null){
            if(k.equals(prev.k)){
                return (V) prev.v;
            }
        }
        return null;
    }

    public void set(K k,V v){
        if(!contain(k)){
            add(k,v);
        }
    }

    @Override
    public String toString() {
        StringBuffer ret = new StringBuffer();
        ret.append("{");
        Node prev = dummyHead.next;
        while (prev!=null){
            ret.append(String.format("'%s':'%s'",prev.k,prev.v));
            if(prev.next!=null)
                ret.append(",");
            prev = prev.next;
        }
        ret.append("}");
        return ret.toString();
    }

    public static void main(String[] args) {
        LinkedList<String,Integer> linked = new LinkedList<>();
        linked.set("hello",1);
        linked.set("hello",1);
        linked.set("world",1);
        System.out.println(linked.toString());
    }

}
