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
        initializeStrikeFrameParser();
    }

    @Test
    public void shouldReturnStrikeFrame() {
        Frame result = normalFrameInterpreter.createFrameFromInput(VALID_FRAME);

        assertTrue(result instanceof NormalFrame);
    }

    @Test
    public void shouldReturnNullFrame() {
        Frame result = normalFrameInterpreter.createFrameFromInput(INVALID_FRAME);

        assertNull(result);
    }

    private void initializeStrikeFrameParser() {
        normalFrameInterpreter = new NormalFrameInterpreter();
    }

}
