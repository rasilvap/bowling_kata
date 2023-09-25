package com.kata.bowling.frames;

public class SpareFrame implements Frame {

    private static final int SCORE = 10;
    private static final int DUPLICATE_DURATION = 1;

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
        return DUPLICATE_DURATION;
    }
}
