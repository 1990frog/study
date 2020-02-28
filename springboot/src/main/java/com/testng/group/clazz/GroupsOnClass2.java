package com.testng.group.clazz;

import org.testng.annotations.Test;

@Test(groups = "classA")
public class GroupsOnClass2 {

    public void test1(){
        System.out.println("2-1");
    }

    public void test2(){
        System.out.println("2-2");
    }
}
