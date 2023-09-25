package com.kata.bowling;

import com.kata.bowling.frames.Frame;
import com.kata.bowling.frames.NormalFrame;

import java.util.LinkedList;
import java.util.List;

class GameManager {

    private static final int FRAMES_PER_GAME = 10;

    private List<Frame> frames = new LinkedList<Frame>();

    void addFrame(Frame frame) {
        frames.add(frame);
    }


    int getScore() {
        int score = 0;
        for (int currentFrame = 0; currentFrame < FRAMES_PER_GAME; currentFrame++) {
            Frame frame = frames.get(currentFrame);
            score = incrementScore(score, frame);
            if (shouldDuplicateNextScores(frame)) {
                score = duplicateNextScores(score, currentFrame, frame);
            }
        }
        return score;
    }

    private int incrementScore(int score, Frame frame) {
        return score + frame.getScore();
    }

    private int incrementScoreForDuplicates(int score, Frame frame) {
        if(frame instanceof NormalFrame){
            return score + frame.getScore();
        }
        return score + frame.getNextFrameScore();
    }

    private boolean shouldDuplicateNextScores(Frame frame) {
        return frame.hasToDuplicateNextFrame() && frame.getDuplicationDuration() > 0;
    }

    private int duplicateNextScores(int score, int currentFrame, Frame frame) {
        final int topNextFrame = currentFrame + 1;
        int nextFrame = topNextFrame;
        while (nextFrame < (topNextFrame + frame.getDuplicationDuration())) {
            score = incrementScoreForDuplicates(score, frames.get(nextFrame));
            if (frames.get(nextFrame).getDuplicationDuration() == 1 && frame.getDuplicationDuration() != 1) {
                nextFrame++;
            }
            nextFrame++;
        }
        return score;
    }

}
