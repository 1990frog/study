package reflection.entity;

import lombok.Data;

@Data
public class Child {
    private String name;
    private int age;
    public Child(String name,int age){
        this.name = name;
        this.age = age;
    }
}
