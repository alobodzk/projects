package com.inkglobal.techtest;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

public class ClockFaceTests {

    private ClockFace clockFace;
    private PrintStream printStream;
    private ByteArrayOutputStream out;

    @Before
    public void setUp() {
        out = new ByteArrayOutputStream();
        printStream = new PrintStream(out);
        clockFace = new BerlinClockFace(printStream);
    }

    @Test
    public void shouldSuccesfullyShow12AM() {

        clockFace.showTime(1396915200000l);
        assertThat(out.toString().trim(), equalTo("Y OOOO OOOO OOOOOOOOOOO OOOO"));
    }

    @Test
    public void shouldSuccesfullyShow13_17_01() {
        clockFace.showTime(1396876621000l);
        assertThat(out.toString().trim(), equalTo("O RROO RRRO YYROOOOOOOO YYOO"));
    }

    @Test
    public void shouldSuccesfullyShow23_59_59() {
        clockFace.showTime(1396915199000l);
        assertThat(out.toString().trim(), equalTo("O RRRR RRRO YYRYYRYYRYY YYYY"));
    }

    @Test
    public void shouldSuccesfullyShow12_00_00() {
        clockFace.showTime(1396872000000l);
        assertThat(out.toString().trim(), equalTo("Y RROO RROO OOOOOOOOOOO OOOO"));
    }
}
