package com.inkglobal.techtest;

import java.io.PrintStream;

public class BerlinClock extends AbstractClock {

    public BerlinClock(PrintStream out) {
        super(new CogImpl(), new BerlinClockFace(out));
    }

    public static void main(String[] args) {
        new BerlinClock(System.out).displayTime();
    }
}
