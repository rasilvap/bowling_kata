package com.kata.bowling.interpreters;

import com.kata.bowling.frames.Frame;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import static com.kata.bowling.Constants.EMPTY_STRING;
import static com.kata.bowling.Constants.SINGLE_VALID_FRAME;

public class LineInterpreter {
    private final Collection<FrameInterpreter> parsers;
    private int parsingIndex;

    public LineInterpreter(Collection<FrameInterpreter> parsers) {
        this.parsers = parsers;
    }


    /**
     * Analyze one line and return a List<Frame> with the associated value for each frame.
     *
     * @param line to split in different frames.
     * @return List<Frame>
     */
    public List<Frame> parse(final String line) {
        List<Frame> frames = new LinkedList<Frame>();
        for (parsingIndex = 0; parsingIndex < line.length(); parsingIndex++) {
            Frame frame = extractNextFrame(line);
            frames.add(frame);
        }
        return frames;
    }

    private boolean isSingleCharacterFrame(String line, int i) {
        return line.charAt(i) == SINGLE_VALID_FRAME;
    }

    private Frame extractNextFrame(String line) {
        String frameToAnalyze;
        if (isSingleCharacterFrame(line, parsingIndex)) {
            frameToAnalyze = line.charAt(parsingIndex) + EMPTY_STRING;
        } else {
            if(parsingIndex + 2 < line.length()){
                frameToAnalyze = line.substring(parsingIndex, parsingIndex + 2);
                parsingIndex++;
            }else{
                frameToAnalyze = line.charAt(parsingIndex) + EMPTY_STRING;
            }

        }
        return getFrame(frameToAnalyze);
    }

    /**
     * Get a Frame by analyzing the given 'frameToAnalyze'.
     *
     * @param frameToAnalyze The frame to analyze.
     * @return The parsed Frame, or null if not found.
     */
    private Frame getFrame(String frameToAnalyze) {
        // Use a stream to process each frameParser in the 'parsers' collection
        // and evaluate 'frameToAnalyze' with each of them
        return parsers.stream()
                .map(frameParser -> frameParser.createFrameFromInput(frameToAnalyze)) // Evaluate
                .filter(frame -> frame != null) // Filter out null results
                .findFirst() // Find the first non-null Frame
                .orElse(null); // Return null if no valid Frame is found
    }

}
