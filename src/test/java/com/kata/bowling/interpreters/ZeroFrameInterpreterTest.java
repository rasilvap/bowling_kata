package com.kata.bowling.interpreters;

import com.kata.bowling.frames.Frame;
import com.kata.bowling.frames.MissedFrame;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class ZeroFrameInterpreterTest {

    private static final String ZERO_FRAME = "NON";
    private static final String NON_ZERO_FRAME = "X-";

    private MissedFrameInterpreter zeroFrameInterpreter;

    @Before
    public void setUp() {
        initializeStrikeFrameInterpreter();
    }

    @Test
    public void shouldReturnStrikeFrame() {
        Frame result = zeroFrameInterpreter.parseFrameInput(ZERO_FRAME);

        assertTrue(result instanceof MissedFrame);
    }

    @Test
    public void shouldReturnNullFrame() {
        Frame result = zeroFrameInterpreter.parseFrameInput(NON_ZERO_FRAME);

        assertNull(result);
    }

    private void initializeStrikeFrameInterpreter() {
        zeroFrameInterpreter = new MissedFrameInterpreter();
    }

}
