package com.kata.bowling.interpreters;

import com.kata.bowling.frames.Frame;
import com.kata.bowling.frames.SpareFrame;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class SpareFrameInterpreterTest {

    private static final String SPARE_FRAME = "7/";
    private static final String NON_SPARE_FRAME = "X9";

    private SpareFrameInterpreter spareFrameInterpreter;

    @Before
    public void setUp() {
        initializeStrikeFrameInterpreter();
    }

    @Test
    public void shouldReturnStrikeFrame() {
        Frame result = spareFrameInterpreter.parseFrameInput(SPARE_FRAME);

        assertTrue(result instanceof SpareFrame);
    }

    @Test
    public void shouldReturnNullFrame() {
        Frame result = spareFrameInterpreter.parseFrameInput(NON_SPARE_FRAME);

        assertNull(result);
    }

    private void initializeStrikeFrameInterpreter() {
        spareFrameInterpreter = new SpareFrameInterpreter();
    }

}
