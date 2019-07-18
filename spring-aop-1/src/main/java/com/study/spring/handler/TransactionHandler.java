package com.study.spring.handler;

public class TransactionHandler {

    public void endTransaction() {
        System.out.println("关闭事务：endTransaction");
    }

    public void beginTransaction() {
        System.out.println("开始启务：beginTransaction");
    }
}
