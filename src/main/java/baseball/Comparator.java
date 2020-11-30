package baseball;
/*
 * Comparator
 *
 * version 1.0
 *
 * 2020.11.30
 *
 * Copyright (c) by Davinci.J
 */
import java.util.*;

public class Comparator {
    private static final String NOTHING = "낫싱";
    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼";
    private static final int NO_COUNT = 0;

    public static String compareNumbersOfCompetitorAndPlayer(String randomNumbersOfCompetitor,
                                                                String numbersOfGamePlayer) {
        int ballCount = calculateBallCount(randomNumbersOfCompetitor, numbersOfGamePlayer);
        int strikeCount = calculateStrikeCount(randomNumbersOfCompetitor, numbersOfGamePlayer);

        if (ballCount == NO_COUNT && strikeCount == NO_COUNT) {
            return NOTHING;
        }

        if (ballCount == NO_COUNT) {
            return strikeCount + STRIKE;
        }

        if (strikeCount == NO_COUNT) {
            return ballCount + BALL;
        }

        return ballCount + BALL + " " + strikeCount + STRIKE;
    }

    private static int calculateBallCount(String randomNumbersOfCompetitor,
                                            String numbersOfGamePlayer) {
        int ballCount = 0;
        List<Character> numbersOfCompetitor = getNumbersOfCompetitor(randomNumbersOfCompetitor);

        for (int i=0; i<randomNumbersOfCompetitor.length(); i++) {
            char numberOfGamePlayer = numbersOfGamePlayer.charAt(i);
            if (randomNumbersOfCompetitor.charAt(i) != numberOfGamePlayer
                && numbersOfCompetitor.contains(numberOfGamePlayer)) {
                ballCount++;
            }
        }

        return ballCount;
    }

    private static List<Character> getNumbersOfCompetitor(String randomNumbersOfCompetitor) {
        List<Character> numbersOfCompetitor = new ArrayList<>();

        for (int i=0; i<randomNumbersOfCompetitor.length(); i++) {
            numbersOfCompetitor.add(randomNumbersOfCompetitor.charAt(i));
        }

        return numbersOfCompetitor;
    }

    private static int calculateStrikeCount(String randomNumbersOfCompetitor,
                                                String numbersOfGamePlayer) {
        int strikeCount = 0;

        for (int i=0; i<randomNumbersOfCompetitor.length(); i++) {
            if (randomNumbersOfCompetitor.charAt(i) == numbersOfGamePlayer.charAt(i)) {
                strikeCount++;
            }
        }

        return strikeCount;
    }

}
