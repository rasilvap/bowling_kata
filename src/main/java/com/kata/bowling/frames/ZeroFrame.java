package com.kata.bowling.frames;


public class ZeroFrame implements Frame {

    private static final int SCORE = 0;

    @Override
    public int getScore() {
        return SCORE;
    }

    @Override
    public boolean hasToDuplicateNextFrame() {
        return false;
    }

    @Override
    public int getDuplicationDuration() {
        return 0;
    }
}
