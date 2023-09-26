package com.kata.bowling.interpreters;

import com.kata.bowling.frames.Frame;
import com.kata.bowling.frames.NormalFrame;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class NormalFrameInterpreterTest {

    private static final String VALID_FRAME = "81";
    private static final String INVALID_FRAME = "S";

    private NormalFrameInterpreter normalFrameInterpreter;

    @Before
    public void setUp() {
        initializeStrikeFrameInterpreter();
    }

    @Test
    public void shouldReturnStrikeFrame() {
        Frame result = normalFrameInterpreter.parseFrameInput(VALID_FRAME);

        assertTrue(result instanceof NormalFrame);
    }

    private void initializeStrikeFrameInterpreter() {
        normalFrameInterpreter = new NormalFrameInterpreter();
    }

}
