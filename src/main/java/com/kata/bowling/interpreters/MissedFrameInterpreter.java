package com.kata.bowling.interpreters;

import com.kata.bowling.frames.Frame;
import com.kata.bowling.frames.MissedFrame;

import static com.kata.bowling.Constants.MISSED_FRAME;

public class MissedFrameInterpreter implements FrameInterpreter {

    @Override
    public Frame parseFrameInput(String frame) {
        Frame result = null;
        if (isMissedFrame(frame)) {
            result = new MissedFrame();
        }
        return result;
    }

    private boolean isMissedFrame(String frame) {
        return MISSED_FRAME.equals(frame);
    }

}
