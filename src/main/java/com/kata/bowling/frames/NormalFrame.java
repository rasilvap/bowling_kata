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
    public boolean hasToDuplicateNextFrame() {
        return false;
    }


    @Override
    public int getDuplicationDuration() {
        return 0;
    }
}
