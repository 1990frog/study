package com.source.ioc.xml;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Student {

    private String name;

    private Integer age;

    private List<String> classList;

    public Student(){}

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
