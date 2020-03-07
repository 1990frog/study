package com.mystarter;

public class MystarterServrice {

    private MystarterSource source;

    public MystarterServrice(MystarterSource source) {
        this.source = source;
    }

    public String getAuthor(){
        return source.getAuthor();
    }
}
