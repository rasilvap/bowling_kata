package com.kata.bowling.interpreters;

import com.kata.bowling.frames.Frame;
import com.kata.bowling.frames.ZeroFrame;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class ZeroFrameInterpreterTest {

    private static final String ZERO_FRAME = "..";
    private static final String NON_ZERO_FRAME = "SS";

    private ZeroFrameInterpreter zeroFrameInterpreter;

    @Before
    public void setUp() {
        initializeStrikeFrameParser();
    }

    @Test
    public void shouldReturnStrikeFrame() {
        Frame result = zeroFrameInterpreter.createFrameFromInput(ZERO_FRAME);

        assertTrue(result instanceof ZeroFrame);
    }

    @Test
    public void shouldReturnNullFrame() {
        Frame result = zeroFrameInterpreter.createFrameFromInput(NON_ZERO_FRAME);

        assertNull(result);
    }

    private void initializeStrikeFrameParser() {
        zeroFrameInterpreter = new ZeroFrameInterpreter();
    }

}
