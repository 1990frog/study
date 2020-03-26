package com.sourcecode.except;

import org.springframework.beans.factory.UnsatisfiedDependencyException;
import org.springframework.boot.SpringBootExceptionReporter;
import org.springframework.context.ConfigurableApplicationContext;

public class MyExceptionReporter implements SpringBootExceptionReporter {

    private ConfigurableApplicationContext context;

    /**
     * 异常报告器在容器refresh之前创建，所以需要注入Context容器
     *
     * exceptionReporters = getSpringFactoriesInstances(SpringBootExceptionReporter.class,
     * 					new Class[] { ConfigurableApplicationContext.class }, context);
     *
     * prepareContext(context, environment, listeners, applicationArguments, printedBanner);
     * refreshContext(context);
     *
     * @param context
     */
    public MyExceptionReporter(ConfigurableApplicationContext context) {
        this.context = context;
    }

    @Override
    public boolean reportException(Throwable failure) {
        if (failure instanceof UnsatisfiedDependencyException) {
            UnsatisfiedDependencyException exception = (UnsatisfiedDependencyException) failure;
            System.out.println("no such bean " + exception.getInjectionPoint().getField().getName() );
        }
        return false;
    }
}
