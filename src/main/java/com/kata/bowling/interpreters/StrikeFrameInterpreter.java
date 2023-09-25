package com.kata.bowling.interpreters;

import com.kata.bowling.frames.Frame;
import com.kata.bowling.frames.StrikeFrame;

import static com.kata.bowling.Constants.*;

public class StrikeFrameInterpreter implements FrameInterpreter {

    @Override
    public Frame createFrameFromInput(String frame) {
        Frame result = null;
        if (STRIKE_ROLL_SEPARATOR.equals(frame)) {
            int nextFramePoints = getScore(frame.charAt(0) + EMPTY_STRING);
            result = new StrikeFrame(nextFramePoints);
        }
        return result;
    }

    private int getScore(String partialFrame) {
        int score = 0;
        if (!ZERO_ROLL.equals(partialFrame)) {
            if(STRIKE_ROLL_SEPARATOR.equals(partialFrame)){
                return 10;
            }
            score = Integer.parseInt(partialFrame);
        }
        return score;
    }
}
