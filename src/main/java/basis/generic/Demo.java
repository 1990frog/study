package basis.generic;

import org.junit.Test;
import org.mortbay.log.Log;

public class Demo<T> {

    public T get1(T t){
        return t;
    }

    public <T> T get2(T t){
        return t;
    }

    public String get3(String t){
        return t;
    }

    @Test
    public void test(){
        Demo demo = new Demo();
        Object obj = demo.get1(new String());
        Log.info(obj.getClass().toString());
        String s = demo.get3("haha");
        Log.info(s);
    }

}
