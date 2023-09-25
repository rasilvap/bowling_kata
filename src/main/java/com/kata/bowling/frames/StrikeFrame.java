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
    public boolean hasToDuplicateNextFrame() {
        return true;
    }


    @Override
    public int getDuplicationDuration() {
        return DUPLICATION_DURATION;
    }

    @Override
    public int getNextFrameScore() {
        return nextFrameScore;
    }
}
