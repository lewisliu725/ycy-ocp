package com.leliu.ycyocp.model;

public class ConsumeResult {
    public static final boolean SUCCEED = true;
    public static final boolean FAILED = false;

    boolean succeed;

    protected ConsumeResult(boolean succeed) {
        this.succeed = succeed;
    }

    public boolean isSucceed() {
        return succeed;
    }

    public void setSucceed(boolean succeed) {
        this.succeed = succeed;
    }

    public static ConsumeResult succeed() {
        return new ConsumeResult(SUCCEED);
    }

    public static ConsumeResult failed() {
        return new ConsumeResult(FAILED);
    }
}
