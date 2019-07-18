package com.study.spring.handler;

import org.apache.commons.lang3.ArrayUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TransationHandlerWithJdkDynamicProxy implements InvocationHandler {

    private  Object targetObject;

    public Object createProxyInstance(){
        return Proxy.newProxyInstance(this.targetObject.getClass().getClassLoader(),
                this.targetObject.getClass().getInterfaces(),
                this);
    }

    public TransationHandlerWithJdkDynamicProxy() {
    }

    public TransationHandlerWithJdkDynamicProxy(Object targetObject) {
        this.targetObject = targetObject;
    }

    /**
     *
     * @param proxy  代理对象
     * @param method 目标对象方法
     * @param args   方法的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object returnObject = null;
        if(proxy == null){
            throw new IllegalArgumentException("");
        }

        if(method == null){
            throw new IllegalArgumentException("");
        }

        String methodName = method.getName();
        if(methodName.startsWith("add") || methodName.startsWith("delete") || methodName.startsWith("modify")){
            beginTransaction();
        }

        returnObject = method.invoke(this.targetObject,args);

        if(methodName.startsWith("add") || methodName.startsWith("delete") || methodName.startsWith("modify")){
            endTransaction();
        }
        return returnObject;

    }

    public void endTransaction() {
        System.out.println("关闭事务：jdk-proxy-endTransaction");
    }

    public void beginTransaction() {
        System.out.println("开始启务：jdk-proxy-beginTransaction");
    }
}
