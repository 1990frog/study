package src.main.java.generic.wildcards;

import org.junit.Test;
import org.mortbay.log.Log;

public class GenericityWildcards {

    class Generic<T>{
        //key这个成员变量的类型为T,T的类型由外部指定
        private T key;

        public Generic(T key) { //泛型构造方法形参key的类型也为T，T的类型由外部指定
            this.key = key;
        }
        public T getKey(){ //泛型方法getKey的返回值类型为T，T的类型由外部指定
            return key;
        }
    }

    public void showKeyValue(Generic<Number> obj){
        Log.info("泛型测试：key value is " + obj.getKey());
    }

    public void showKeyValue1(Generic<?> obj){
        Log.info("泛型测试：key value is " + obj.getKey());
    }

    public void showKeyValue2(Generic<? extends Number> obj){
        Log.info("泛型测试：key value is " + obj.getKey());
    }

    /**
     * 泛型不支持直接向上转型，但是支持通过参数通配符向上转型
     */
    @Test
    public void test(){
        Generic<Number> gNumber = new Generic<>(456);
        showKeyValue(gNumber);
        Generic<Integer> gInteger = new Generic<>(123);
        //showKeyValue(gInteger);
        showKeyValue1(gInteger);
        showKeyValue2(gInteger);
    }




}
