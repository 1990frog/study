package com.action.testng.group.method;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class GroupOnMethod {

    @Test(groups = "server")
    public void server1(){
        System.out.println("服务端组1");
    }

    @Test(groups = "server")
    public void server2(){
        System.out.println("服务端组2");
    }

    @Test(groups = "client")
    public void client1(){
        System.out.println("客户端组1");
    }

    @Test(groups = "client")
    public void client2(){
        System.out.println("客户端组2");
    }

    @BeforeGroups("server")
    public void beforeGroupsOnServer(){
        System.out.println("这是服务端组运行之前运行的方法");
    }

    @AfterGroups("server")
    public void afterGroupsOnServer(){
        System.out.println("这是服务端组运行之后运行的方法");
    }
}
