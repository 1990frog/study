package javase.base.lambda.syntax;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@FunctionalInterface
interface Action{
    String action();
    default String getInfo(){
        return "this is a FunctionalInterface";
    }
    static Class getClazz(){
        return Action.class;
    }
}

@Slf4j
public class Syntax {

    @Test
    public void test(){
        Action a1 = new Action() {
            @Override
            public String action() {
                return "foo";
            }
        };

        Action a2 = ()-> "bar";

        log.info(a1.action());
        log.info(a2.action());
    }
}
