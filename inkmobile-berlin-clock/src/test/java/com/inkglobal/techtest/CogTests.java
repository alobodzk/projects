package com.inkglobal.techtest;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Calendar;

import org.junit.Test;

public class CogTests {
    private Cog cog = new CogImpl();

    @Test
    public void shouldReturnSecondLater() {
        long start = System.currentTimeMillis();
        long end = cog.move();

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(start);
        int startSecond = calendar.get(Calendar.SECOND);
        calendar.setTimeInMillis(end);
        int endSecond = calendar.get(Calendar.SECOND);
        assertThat(endSecond, equalTo(startSecond + 1));
    }
}
