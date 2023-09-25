package com.kata.bowling;

import com.kata.bowling.frames.NormalFrame;
import com.kata.bowling.frames.SpareFrame;
import com.kata.bowling.frames.StrikeFrame;
import com.kata.bowling.frames.ZeroFrame;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameManagerTest {

    private GameManager gameManager;

    @Before
    public void setUp() {
        initializeBowlingGame();
    }

    @Test
    public void shouldReturnZeroScore() {
        for (int i = 0; i < 10; i++) {
            ZeroFrame zeroFrame = generateZeroFrame();
            gameManager.addFrame(zeroFrame);
        }

        assertEquals(0, gameManager.getScore());
    }


    @Test
    public void shouldReturnSumOfNormalFramesAsScore() {
        for (int i = 0; i < 10; i++) {
            NormalFrame normalFrame = generateNormalFrame(i);
            gameManager.addFrame(normalFrame);
        }

        assertEquals(45, gameManager.getScore());
    }


    @Test
    public void shouldReturnPerfectScore() {
        for (int i = 0; i < 12; i++) {
            StrikeFrame strikeFrame = generateStrikeFrame();
            gameManager.addFrame(strikeFrame);
        }

        assertEquals(300, gameManager.getScore());
    }

    @Test
    public void souldReturnPerfectSpareScore() {
        for (int i = 0; i < 11; i++) {
            SpareFrame spareFrame = generateSpareFrame();
            gameManager.addFrame(spareFrame);
        }

        assertEquals(200, gameManager.getScore());
    }


    @Test
    public void shouldReturnSumOfNormalFramesCombinedWithSpares() {
        gameManager.addFrame(new NormalFrame(2, 3));
        gameManager.addFrame(new NormalFrame(8, 1));
        gameManager.addFrame(new NormalFrame(4, 3));
        gameManager.addFrame(new StrikeFrame(5));
        gameManager.addFrame(new StrikeFrame(1));
        gameManager.addFrame(new SpareFrame(1));
        gameManager.addFrame(new ZeroFrame());
        gameManager.addFrame(new NormalFrame(1, 8));
        gameManager.addFrame(new SpareFrame(1));
        gameManager.addFrame(new StrikeFrame(5));
        gameManager.addFrame(new StrikeFrame(5));
        gameManager.addFrame(new StrikeFrame(5));

        assertEquals(98, gameManager.getScore());
    }

    @Test
    public void shouldReturnSumOfNormalFramesCombinedWithStrikes() {
        gameManager.addFrame(new NormalFrame(5, 4));
        gameManager.addFrame(new NormalFrame(5, 4));
        gameManager.addFrame(new NormalFrame(5, 4));
        gameManager.addFrame(new NormalFrame(5, 4));
        gameManager.addFrame(new NormalFrame(5, 4));
        gameManager.addFrame(new NormalFrame(5, 4));
        gameManager.addFrame(new NormalFrame(5, 4));
        gameManager.addFrame(new NormalFrame(5, 4));
        gameManager.addFrame(new NormalFrame(5, 4));
        gameManager.addFrame(new StrikeFrame(10));
        gameManager.addFrame(new StrikeFrame(10));
        gameManager.addFrame(new StrikeFrame(10));

        assertEquals(111, gameManager.getScore());
    }

    @Test
    public void shouldReturnSumOfNormalFramesCombinedWithSparesAndStrikes() {
        gameManager.addFrame(new SpareFrame(1));
        gameManager.addFrame(new NormalFrame(5, 4));
        gameManager.addFrame(new NormalFrame(5, 4));
        gameManager.addFrame(new NormalFrame(5, 4));
        gameManager.addFrame(new NormalFrame(5, 4));
        gameManager.addFrame(new SpareFrame(1));
        gameManager.addFrame(new NormalFrame(5, 4));
        gameManager.addFrame(new NormalFrame(5, 4));
        gameManager.addFrame(new NormalFrame(5, 4));
        gameManager.addFrame(new StrikeFrame(10));
        gameManager.addFrame(new StrikeFrame(10));
        gameManager.addFrame(new StrikeFrame(10));

        assertEquals(131, gameManager.getScore());
    }

    private void initializeBowlingGame() {
        gameManager = new GameManager();
    }

    private ZeroFrame generateZeroFrame() {
        return new ZeroFrame();
    }

    private NormalFrame generateNormalFrame(int puntuation) {
        return new NormalFrame(puntuation, 0);
    }

    private StrikeFrame generateStrikeFrame() {
        return new StrikeFrame(10);
    }

    private SpareFrame generateSpareFrame() {
        return new SpareFrame(10);
    }
}
