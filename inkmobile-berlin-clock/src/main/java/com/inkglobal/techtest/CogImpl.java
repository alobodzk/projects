package com.inkglobal.techtest;

import java.util.concurrent.TimeUnit;

public class CogImpl implements Cog {

    @Override
    public long move() {
        try {
            Thread.sleep(TimeUnit.SECONDS.toMillis(1));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return System.currentTimeMillis();
    }

}
