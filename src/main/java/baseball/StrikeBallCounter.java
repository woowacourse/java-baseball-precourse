package baseball;

import java.util.stream.IntStream;

public class StrikeBallCounter {

    public static int getStrikeCount(int[] generateNumbers, int[] guessNumbers) {
        int strikeNum = 0;
        for (int i = 0; i < Constant.DIGIT_NUM; i++) {
            strikeNum += isStrike(generateNumbers[i], guessNumbers[i]);
        }
        return strikeNum;
    }

    private static int isStrike(int generatedNumberInDigit, int guessNumberInDigit) {
        if (generatedNumberInDigit == guessNumberInDigit) return Constant.ONE;
        else return Constant.ZERO;
    }

    public static int getBallCount(int[] generateNumbers, int[] guessNumbers) {
        int ballNum = 0;
        for (int i = 0; i < Constant.DIGIT_NUM; i++) {
            ballNum += isBall(generateNumbers, guessNumbers, i);
        }
        return ballNum;
    }

    private static int isBall(int[] generateNumbers, int[] guessNumbers, int index) {
        if (IntStream.of(generateNumbers).anyMatch(x -> x == guessNumbers[index]) && generateNumbers[index] != guessNumbers[index]) {
            return Constant.ONE;
        } else return Constant.ZERO;
    }
}
