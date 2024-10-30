package learn_synchronizedcontainer;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Hashtable;

public class HashtableSample {

    static final Hashtable<String,String> hashtable = new Hashtable<>();

    static final HashMap<String, String> hashmap = new HashMap<>();

    @Test
    public void testNullKeyNullValue(){
        hashmap.put("A", null);
        System.out.println(hashmap);
        hashmap.put(null, "A");
        System.out.println(hashmap);
        try {
            hashtable.put("A", null);
        }catch (NullPointerException e){
            System.out.println("Hashtable key 不允许为空！");
        }
        try {
            hashtable.put(null, "A");
        }catch (NullPointerException e){
            System.out.println("Hashtable value 不允许为空！");
        }
    }
}
