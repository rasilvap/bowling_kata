package com.kata.bowling.interpreters;

import com.kata.bowling.frames.Frame;
import com.kata.bowling.frames.SpareFrame;

import static com.kata.bowling.Constants.EMPTY_STRING;
import static com.kata.bowling.Constants.SPARE_SEPARATOR;

public class SpareFrameInterpreter implements FrameInterpreter {

    @Override
    public Frame createFrameFromInput(String frame) {
        Frame result = null;
        if (isSpareFrame(frame)) {
            result = new SpareFrame();
        }
        return result;
    }

    private boolean isSpareFrame(String frame) {
        return SPARE_SEPARATOR.equals(frame.charAt(1) + EMPTY_STRING);
    }

}
