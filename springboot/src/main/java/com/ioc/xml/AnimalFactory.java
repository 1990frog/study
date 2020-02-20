package com.ioc.xml;

public class AnimalFactory {

    public static Animal getAnimal(String type) {
        if ("dog".equals(type)) {
            return new Dog();
        } else {
            return new Cat();
        }
    }

}
