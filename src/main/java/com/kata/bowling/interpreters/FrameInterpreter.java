package com.kata.bowling.interpreters;

import com.kata.bowling.frames.Frame;

public interface FrameInterpreter {
    Frame parseFrameInput(String frame);

}
