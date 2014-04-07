package com.inkglobal.techtest;

public abstract class AbstractClock implements Clock {
    private Cog cog;
    private ClockFace clockFace;
    private boolean run = true;

    public AbstractClock(Cog cog, ClockFace clockFace) {
        this.cog = cog;
        this.clockFace = clockFace;
    }

    @Override
    public void displayTime() {
        do {
            clockFace.showTime(cog.move());
        } while (run);
    }

    @Override
    public void stop() {
        run = false;
    }

    void setCog(Cog cog) {
        this.cog = cog;
    }
}
