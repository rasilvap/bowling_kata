package com.kata.bowling.interpreters;

import com.kata.bowling.frames.Frame;
import com.kata.bowling.frames.StrikeFrame;

import static com.kata.bowling.Constants.STRIKE_ROLL_SEPARATOR;

public class StrikeFrameInterpreter implements FrameInterpreter {

    @Override
    public Frame createFrameFromInput(String frame) {
        Frame result = null;
        if (STRIKE_ROLL_SEPARATOR.equals(frame)) {
            result = new StrikeFrame();
        }
        return result;
    }
}
