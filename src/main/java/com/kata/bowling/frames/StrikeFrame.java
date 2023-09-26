package com.kata.bowling.frames;

public class StrikeFrame implements Frame {
    private final int nextFrameScore;
    public StrikeFrame(int nextFrameScore) {
        this.nextFrameScore = nextFrameScore;
    }
    private static final int SCORE = 10;
    private static final int DUPLICATION_DURATION = 2;

    @Override
    public int getScore() {
        return SCORE;
    }

    @Override
    public boolean shouldIncreaseNextFrame() {
        return true;
    }


    @Override
    public int getIncreaseTimes() {
        return DUPLICATION_DURATION;
    }

    @Override
    public int getNextFrameScore() {
        return nextFrameScore;
    }
}
