package com.kata.bowling.interpreters;

import com.kata.bowling.frames.Frame;
import com.kata.bowling.frames.SpareFrame;

import static com.kata.bowling.Constants.*;

public class SpareFrameInterpreter implements FrameInterpreter {

    @Override
    public Frame createFrameFromInput(String frame) {
        Frame result = null;
        if (isSpareFrame(frame)) {
            int secondRoll = getScore(frame.charAt(0) + EMPTY_STRING);
            result = new SpareFrame(secondRoll);
        }
        return result;
    }

    private boolean isSpareFrame(String frame) {
        return (frame.length() == 2 && SPARE_SEPARATOR.equals(frame.charAt(1) + EMPTY_STRING))
                || (frame.length() == 1 && SPARE_SEPARATOR.equals(frame + EMPTY_STRING) );
    }

    private int getScore(String partialFrame) {
        int score = 0;
        if (!ZERO_ROLL.equals(partialFrame)) {
            score = Integer.parseInt(partialFrame);
        }
        return score;
    }

}
