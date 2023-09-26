package com.kata.bowling;

import com.kata.bowling.frames.Frame;
import com.kata.bowling.interpreters.*;

import java.util.LinkedList;
import java.util.List;

public class BowlingScoreCalculator {

    private LineInterpreter lineInterpreter;


    public BowlingScoreCalculator() {
        setupFrameInterpreters();
    }

    public int getScore(String rolls) {
        List<Frame> frames = lineInterpreter.parse(rolls);
        return getScore(frames);
    }

    private void setupFrameInterpreters() {
        var interpreters = new LinkedList<FrameInterpreter>();
        interpreters.add(new StrikeFrameInterpreter());
        interpreters.add(new SpareFrameInterpreter());
        interpreters.add(new NormalFrameInterpreter());
        interpreters.add(new ZeroFrameInterpreter());
        lineInterpreter = new LineInterpreter(interpreters);
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
