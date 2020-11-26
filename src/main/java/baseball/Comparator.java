package baseball;

import java.util.*;

public class Comparator {

    public static String getComparativeResult(String randomNumbersOfCompetitor,
                                                    String randomNumbersOfGamePlayer){
        int ballCount = getBallCount(randomNumbersOfCompetitor, randomNumbersOfGamePlayer);
        int strikeCount = getStrikeCount(randomNumbersOfCompetitor, randomNumbersOfGamePlayer);

        if(ballCount == 0 && strikeCount == 0){
            return "낫싱";
        }

        if(ballCount == 0){
            return strikeCount + "스트라이크";
        }

        if(strikeCount == 0){
            return ballCount + "볼";
        }

        return ballCount + "볼 " + strikeCount + "스트라이크";
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
