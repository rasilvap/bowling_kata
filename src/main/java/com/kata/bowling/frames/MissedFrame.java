package com.kata.bowling.frames;

public class MissedFrame implements Frame {

    private static final int SCORE = 0;

    @Override
    public int getScore() {
        return SCORE;
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
