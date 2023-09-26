package com.kata.bowling.interpreters;

import com.kata.bowling.frames.Frame;
import com.kata.bowling.frames.ZeroFrame;

import static com.kata.bowling.Constants.ZERO_FRAME;

public class ZeroFrameInterpreter implements FrameInterpreter {

    @Override
    public Frame parseFrameInput(String frame) {
        Frame result = null;
        if (isZeroFrame(frame)) {
            result = new ZeroFrame();
        }
        return result;
    }

    private boolean isZeroFrame(String frame) {
        return ZERO_FRAME.equals(frame);
    }

}
