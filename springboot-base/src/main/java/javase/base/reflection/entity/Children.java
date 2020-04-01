package javase.base.reflection.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;

@Data
public class Children extends Parent  {

    private BigDecimal money;
    private BigInteger count;
    private String name;

    @Override
    public String toString() {
        return "children";
    }

    private void privateMethod(){
        System.out.println("private method");
    }

    public static void staticMehtod1(){}
    private static void staticMehtod2(){}

}
