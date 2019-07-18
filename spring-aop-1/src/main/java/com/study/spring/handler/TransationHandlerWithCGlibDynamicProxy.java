package com.study.spring.handler;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.InvocationHandler;

import java.lang.reflect.Method;

public class TransationHandlerWithCGlibDynamicProxy implements InvocationHandler {

    private Object targetObj;

    public TransationHandlerWithCGlibDynamicProxy() {
    }

    public TransationHandlerWithCGlibDynamicProxy(Object targetObj) {
        this.targetObj = targetObj;
    }

    public Object createProxyInstance(){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.targetObj.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

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

        returnObject = method.invoke(this.targetObj,args);

        if(methodName.startsWith("add") || methodName.startsWith("delete") || methodName.startsWith("modify")){
            endTransaction();
        }
        return returnObject;
    }
    public void endTransaction() {
        System.out.println("cglib 关闭事务：jdk-proxy-endTransaction");
    }

    public void beginTransaction() {
        System.out.println("cglib 开始启务：jdk-proxy-beginTransaction");
    }
}
