package baseball;

import java.util.*;

public class Comparator {
    private static final String NOTHING = "낫싱";
    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼";
    private static final int NO_COUNT = 0;

    public static String getComparativeResult(String randomNumbersOfCompetitor,
                                                    String randomNumbersOfGamePlayer){
        int ballCount = getBallCount(randomNumbersOfCompetitor, randomNumbersOfGamePlayer);
        int strikeCount = getStrikeCount(randomNumbersOfCompetitor, randomNumbersOfGamePlayer);

        if(ballCount == NO_COUNT && strikeCount == NO_COUNT){
            return NOTHING;
        }

        if(ballCount == NO_COUNT){
            return strikeCount + STRIKE;
        }

        if(strikeCount == NO_COUNT){
            return ballCount + BALL;
        }

        return ballCount + BALL + " " + strikeCount + STRIKE;
    }

    private static int getBallCount(String randomNumbersOfCompetitor,
                                        String randomNumbersOfGamePlayer){
        int ballCount = 0;
        List<Character> numbersOfCompetitor = getNumbersOfCompetitor(randomNumbersOfCompetitor);
        for(int i=0; i<randomNumbersOfCompetitor.length(); i++){
            char randomNumberOfGamePlayer = randomNumbersOfGamePlayer.charAt(i);
            if(randomNumbersOfCompetitor.charAt(i) != randomNumberOfGamePlayer
                && numbersOfCompetitor.contains(randomNumberOfGamePlayer)){
                ballCount++;
            }
        }
        return ballCount;
    }

    private static List<Character> getNumbersOfCompetitor(String randomNumbersOfCompetitor){
        List<Character> numbersOfCompetitor = new ArrayList<>();
        for(int i=0; i<randomNumbersOfCompetitor.length(); i++){
            numbersOfCompetitor.add(randomNumbersOfCompetitor.charAt(i));
        }
        return numbersOfCompetitor;
    }

    private static int getStrikeCount(String randomNumbersOfCompetitor,
                                        String randomNumbersOfGamePlayer){
        int strikeCount = 0;
        for(int i=0; i<randomNumbersOfCompetitor.length(); i++){
            if(randomNumbersOfCompetitor.charAt(i) == randomNumbersOfGamePlayer.charAt(i)){
                strikeCount++;
            }
        }
        return strikeCount;
    }

}
