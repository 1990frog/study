package com.ioc;

public class BeanDefinition<T> {
    private String beanName;
    private Class<T> beanClass;

    public Class<T> getBeanClass() {
        return beanClass;
    }
}
