package com.kata.bowling;

import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertEquals;

public class BowlingScoreCalculatorTest {

    private BowlingScoreCalculator bowlingScoreCalculator;

    private Map<String, Integer> rollsSequencesList;

    @Before
    public void setUp() {
        initializeBowling();
        generateRollsSequencesList();
    }

    @Test
    public void shouldCalculateTheCorrectScore() {
        for (String key : rollsSequencesList.keySet()) {
            int result = bowlingScoreCalculator.getScore(key);
            int expectedResult = rollsSequencesList.get(key);

            assertEquals(expectedResult, result);
        }
    }

    private void initializeBowling() {
        bowlingScoreCalculator = new BowlingScoreCalculator();
    }

    private void generateRollsSequencesList() {
        rollsSequencesList = Map.of(
                "5/5/5/5/5/5/5/5/5/5/5/", 200,
                "1-1-1-1-1-1-1-1-1-1-", 10,
                "2-2-2-2-2-2-2-2-2-2-", 20,
                "524653XX5/--189/XXX", 144,
                "XXXXXXXXXXXX", 300,
                "--------------------", 0
        );
    }

}
