package com.ioc;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ApplicationContext {
    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();
    private Map<String, Object> stringObjectMap = new ConcurrentHashMap<>();

    public Object getBean(String beanName) throws InstantiationException, IllegalAccessException {
        Object bean = stringObjectMap.get(beanName);
        if (bean == null) {
            doCreateBean(beanName);
        }
        return bean;
    }

    public void doCreateBean(String beanName) throws InstantiationException, IllegalAccessException {
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        Object bean = beanDefinition.getBeanClass().newInstance();
        Field[] fields = bean.getClass().getDeclaredFields();
        for (Field field : fields) {
            Autowired autowired = field.getAnnotation(Autowired.class);
            if (autowired != null) {
                field.setAccessible(true);
                field.set(bean, stringObjectMap.get(field.getName()));
            }
        }

        if (bean instanceof BeanFactoryAware) {

        }
        stringObjectMap.put(beanName, bean);

    }
}
