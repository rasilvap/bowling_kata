package com.kata.bowling.frames;

public class NormalFrame implements Frame {

    private final int firstRoll;
    private final int secondRoll;

    public NormalFrame(int firstRoll, int secondRoll) {
        this.firstRoll = firstRoll;
        this.secondRoll = secondRoll;
    }

    @Override
    public int getScore() {
        return firstRoll + secondRoll;
    }

    @Override
    public boolean shouldIncreaseNextFrame() {
        return false;
    }


    @Override
    public int getIncreaseTimes() {
        return 0;
    }

    @Override
    public int getNextFrameScore() {
        return 0;
    }
}
