package com.testng.group.clazz;

import org.testng.annotations.Test;

@Test(groups = "classA")
public class GroupsOnClass1 {

    public void test1(){
        System.out.println("1-1");
    }

    public void test2(){
        System.out.println("1-2");
    }
}
