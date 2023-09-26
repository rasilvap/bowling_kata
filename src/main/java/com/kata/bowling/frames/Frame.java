package com.kata.bowling.frames;

/**
 * Represents a frame in a game of American Ten-Pin Bowling.
 */
public interface Frame {

    /**
     * Gets the score of the frame.
     *
     * @return The score of the frame.
     */
    int getScore();

    /**
     * Checks if this frame should increase the score of the next frame.
     *
     * @return True if the next frame's score should be increased; otherwise, false.
     */
    boolean shouldIncreaseNextFrame();

    /**
     * Gets the duration of the increase for the next frame.
     *
     * @return The duration of the increase for the next frame.
     */
    int getIncreaseTimes();

    /**
     * Gets the score of the next frame, depending on the Frame type.
     *
     * @return The score of the next frame.
     */
    int getNextFrameScore();

}
