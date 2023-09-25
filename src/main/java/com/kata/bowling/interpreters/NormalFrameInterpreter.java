package com.kata.bowling.interpreters;

import com.kata.bowling.frames.Frame;
import com.kata.bowling.frames.NormalFrame;

import static com.kata.bowling.Constants.EMPTY_STRING;
import static com.kata.bowling.Constants.ZERO_ROLL;

public class NormalFrameInterpreter implements FrameInterpreter {

    @Override
    public Frame createFrameFromInput(String frame) {
        Frame result = null;
        if (isNormalFrame(frame)) {
            int firstRoll = getScore(frame.charAt(0) + EMPTY_STRING);
            int secondRoll = (frame.length() == 2) ? getScore(frame.charAt(1) + EMPTY_STRING) : 0;
            result = getFrame(firstRoll, secondRoll);
        }
        return result;
    }

    private boolean isNormalFrame(String frame) {
        return frame.length() == 1 || frame.length() == 2;
    }

    private Frame getFrame(int firstThrow, int secondThrow) {
        return new NormalFrame(firstThrow, secondThrow);
    }

    private int getScore(String partialFrame) {
        int score = 0;
        if (!ZERO_ROLL.equals(partialFrame)) {
            score = Integer.parseInt(partialFrame);
        }
        return score;
    }
}
