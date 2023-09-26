package com.kata.bowling.interpreters;

import com.kata.bowling.frames.Frame;
import com.kata.bowling.frames.StrikeFrame;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class StrikeFrameInterpreterTest {

    private static final String STRIKE_FRAME = "X";
    private static final String NON_STRIKE_FRAME = "NON";

    private StrikeFrameInterpreter strikeFrameInterpreter;

    @Before
    public void setUp() {
        initializeStrikeFrameInterpreter();
    }

    @Test
    public void shouldReturnStrikeFrame() {
        Frame result = strikeFrameInterpreter.parseFrameInput(STRIKE_FRAME);

        assertTrue(result instanceof StrikeFrame);
    }

    @Test
    public void shouldReturnNullFrame() {
        Frame result = strikeFrameInterpreter.parseFrameInput(NON_STRIKE_FRAME);

        assertNull(result);
    }

    private void initializeStrikeFrameInterpreter() {
        strikeFrameInterpreter = new StrikeFrameInterpreter();
    }

}
