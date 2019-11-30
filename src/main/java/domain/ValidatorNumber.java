package domain;

import java.util.Arrays;
import java.util.List;

public class ValidatorNumber implements Validator {
    private static final String DEFALUT_STRING_BLANK = "";
    private static final int DEFALUT_INT_ZERO = 0;
    private int strike = 0;

    public int getStrike() {
        return strike;
    }

    @Override
    public String randomNumberCompareToUserInput(int randomNumber, int userInput) {
        strike = DEFALUT_INT_ZERO;
        int ball = DEFALUT_INT_ZERO;

        List<String> randomNumberList = Arrays.asList(String.valueOf(randomNumber).split(DEFALUT_STRING_BLANK));
        String[] userInputArray = String.valueOf(userInput).split(DEFALUT_STRING_BLANK);
        for (int i = 0; i < userInputArray.length; i++) {
            if (randomNumberList.get(i).equals(userInputArray[i]))
                strike++;
            else if (randomNumberList.contains(userInputArray[i])
                    && randomNumberList.indexOf(userInputArray[i]) != i)
                ball++;
        }
        return printResult(strike, ball);
    }

    private String printResult(int strikeCount, int ballCount) {
        StringBuilder sb = new StringBuilder();

        if (strikeCount == DEFALUT_INT_ZERO && ballCount == DEFALUT_INT_ZERO)
            sb.append("NOTHING");
        if (strikeCount > DEFALUT_INT_ZERO)
            sb.append("STRIKE : ").append(strikeCount).append(" ");
        if (ballCount > DEFALUT_INT_ZERO)
            sb.append("BALL : ").append(ballCount);
        return sb.toString();
    }
    public boolean gameOver(){
        if(strike==3)
            return true;
        return false;
    }
}
