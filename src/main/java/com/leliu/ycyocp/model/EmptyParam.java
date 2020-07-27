package com.leliu.ycyocp.model;

public class EmptyParam implements ProduceParam {
    private static EmptyParam instance;

    private EmptyParam() {
        if (instance != null) {
            throw new IllegalStateException("Use getInstance() method to create");
        }
    }

    public static EmptyParam getInstance() {
        if (instance == null) {
            synchronized (EmptyParam.class) {
                if (instance == null) {
                    instance = new EmptyParam();
                }
            }
        }
        return instance;
    }
}
