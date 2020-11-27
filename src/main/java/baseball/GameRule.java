package baseball;

import java.util.List;

public class GameRule {

    private GameRule(){}

    public static int countStrike(List target, List guessed){
        return (int)guessed.stream()
                .filter(x -> x == target.get(guessed.indexOf(x))).count();
    }

    public static int countBall(List target, List guessed){
        return countContainBoth(target, guessed) - countStrike(target, guessed);
    }

    private static int countContainBoth(List target, List guessed){
        return (int)guessed.stream()
                .filter(x-> target.contains(x)).count();
    }

    public static boolean checkGameEnd(int strikeCnt, int digits){
        return strikeCnt == digits;
    }
}
