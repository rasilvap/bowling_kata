package com.kata.bowling;

import com.kata.bowling.frames.Frame;
import com.kata.bowling.frames.NormalFrame;
import com.kata.bowling.frames.StrikeFrame;

import java.util.LinkedList;
import java.util.List;

import static com.kata.bowling.util.Constants.FRAME_NUMBERS;

class BowlingScoreCalculator {
    private List<Frame> frames = new LinkedList<Frame>();

    void addFrame(Frame frame) {
        frames.add(frame);
    }


    int getScore() {
        int score = 0;
        for (int currentFrame = 0; currentFrame < FRAME_NUMBERS; currentFrame++) {
            Frame frame = frames.get(currentFrame);
            score = incrementScore(score, frame);
            if (shouldAddAdditionalScores(frame)) {
                score = addAdditionalScores(score, currentFrame, frame);
            }
        }
        return score;
    }

    private int incrementScore(int score, Frame frame) {
        return score + frame.getScore();
    }

    private int calculateAdditionalScore(int score, Frame frame) {
        if(frame instanceof NormalFrame){
            return score + frame.getScore();
        }
        return score + frame.getNextFrameScore();
    }

    private boolean shouldAddAdditionalScores(Frame frame) {
        return frame.shouldIncreaseNextFrame() && frame.getIncreaseTimes() > 0;
    }

    private int addAdditionalScores(int currentScore, int currentFrameIndex, Frame currentFrame) {
        // Calculate the index of the next frame after the current frame
        final var nextFrameIndex = currentFrameIndex + 1;

        // Calculate the index of the last frame to duplicate based on current frame's rules
        final var lastFrameToDuplicateIndex = nextFrameIndex + currentFrame.getIncreaseTimes();

        // Iterate through frames to add duplicated scores
        for (int i = nextFrameIndex; i < lastFrameToDuplicateIndex; i++) {

            if(i == frames.size() && currentFrame instanceof StrikeFrame){
                break;
            } else{
                currentScore = calculateAdditionalScore(currentScore, frames.get(i));

                // Handle special case when the current frame's duplication is different from the next frame's
                if (frames.get(i).getIncreaseTimes() == 1 && currentFrame.getIncreaseTimes() != 1) {
                    i++;
                }
            }
        }
         return currentScore;
    }

}
