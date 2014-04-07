package com.inkglobal.techtest;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BerlinClockTest {

    @Mock
    private Cog cog;

    private BerlinClock clock;

    private ByteArrayOutputStream out;

    private PrintStream printStream;

    @Before
    public void setUp() {
        out = new ByteArrayOutputStream();
        printStream = new PrintStream(out);
        clock = new BerlinClock(printStream);
        clock.setCog(cog);
        clock.stop();
    }

    @Test
    public void shouldSuccesfullyShow12AM() {
        when(cog.move()).thenReturn(1396915200000l);
        clock.displayTime();
        assertThat(out.toString().trim(), equalTo("Y OOOO OOOO OOOOOOOOOOO OOOO"));
    }

    @Test
    public void shouldSuccesfullyShow13_17_01() {
        when(cog.move()).thenReturn(1396876621000l);
        clock.displayTime();
        assertThat(out.toString().trim(), equalTo("O RROO RRRO YYROOOOOOOO YYOO"));
    }

    @Test
    public void shouldSuccesfullyShow23_59_59() {
        when(cog.move()).thenReturn(1396915199000l);
        clock.displayTime();
        assertThat(out.toString().trim(), equalTo("O RRRR RRRO YYRYYRYYRYY YYYY"));
    }

    @Test
    public void shouldSuccesfullyShow12_00_00() {
        when(cog.move()).thenReturn(1396872000000l);
        clock.displayTime();
        assertThat(out.toString().trim(), equalTo("Y RROO RROO OOOOOOOOOOO OOOO"));
    }
}
