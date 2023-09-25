package com.kata.bowling;


import com.kata.bowling.frames.Frame;
import com.kata.bowling.interpreters.*;


import java.util.Collection;
import java.util.LinkedList;
import java.util.List;


public class BowlingScoreCalculator {

    private LineInterpreter lineParser;


    public BowlingScoreCalculator() {
        initializeLineParser();
    }


    /**
     * Calculate the score of a roll sequence for a bowling game.
     *
     * @param rolls valid sequence of rolls in one line.
     * @return calculated score.
     */
    public int getScore(String rolls) {
        List<Frame> frames = lineParser.parse(rolls);
        return getScore(frames);
    }

    private void initializeLineParser() {
        Collection<FrameInterpreter> parsers = new LinkedList<FrameInterpreter>();
        parsers.add(new StrikeFrameInterpreter());
        parsers.add(new SpareFrameInterpreter());
        parsers.add(new NormalFrameInterpreter());
        parsers.add(new ZeroFrameInterpreter());
        lineParser = new LineInterpreter(parsers);
    }

    private int getScore(final List<Frame> frames) {
        GameManager bowlingGame = createBowlingGame(frames);
        return bowlingGame.getScore();
    }

    private GameManager createBowlingGame(List<Frame> frames) {
        GameManager bowlingGame = new GameManager();
        for (Frame frame : frames) {
            bowlingGame.addFrame(frame);
        }
        return bowlingGame;
    }

}
