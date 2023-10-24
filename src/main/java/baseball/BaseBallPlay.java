package baseball;

import static constants.BaseballMessage.*;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.regex.Pattern;


public class BaseBallPlay {

    StringBuilder checkMessage = new StringBuilder();

    private void printAnswerCheck(List<Integer> answer, List<Integer> input) {
        int strike = countStrike(answer, input);
        int ball = countBall(answer, input);

        System.out.println(correctAnswerCheck(strike, ball));
        if(strike == 3) {
            System.out.println(GAME_SUCCESS_MESSAGE);
        }
    }

    private String inputRestartOrExit() {
        System.out.println(GAME_RESTART_OR_END_MESSAGE);
        String endMessage = Console.readLine();
        if(!isSelectMessage(endMessage)) {
            throw new IllegalArgumentException();
        }
        return endMessage;
    }

    private boolean isSelectMessage(String input) {
        Pattern pattern = Pattern.compile("[1-2]");
        return pattern.matcher(input).matches();
    }

    private String correctAnswerCheck (int strike, int ball) {

        if(strike != 0) {
            if(ball != 0) {
                MessageBallStrikeAppend(ball,strike);
            }
            MessageStrikeAppend(strike);
        }
        if(ball != 0) {
            MessageBallAppend(ball);
        }
        return MessageNothingAppend();
    }

    private String MessageBallStrikeAppend(int ball,int strike){
        checkMessage.append(ball).append(BALL).append(strike).append(STRIKE).append("\n");
        return checkMessage.toString();
    }

    private String MessageBallAppend(int ball){
        checkMessage.append(ball).append(BALL).append("\n");
        return checkMessage.toString();
    }

    private String MessageStrikeAppend(int strike){
        checkMessage.append(strike).append(STRIKE).append("\n");
        return checkMessage.toString();
    }

    private String MessageNothingAppend(){
        checkMessage.append(NOTHING);
        return checkMessage.toString();
    }

    private int countStrike(List<Integer> answer, List<Integer> userinput) {
        int strike = 0;
        for (int idx = 0; idx < answer.size(); idx++) {
            if(answer.get(idx).equals(userinput.get(idx))) {
                strike++;
            }
        }
        return strike;
    }

    private int countBall(List<Integer> answer, List<Integer> userinput) {
        int ballcount = 0;
        for(int idx = 0; idx < answer.size(); idx++) {
            if(!answer.get(idx).equals(userinput.get(idx)) && userinput.contains(answer.get(idx))) {
                ballcount++;
            }
        }
        return ballcount;
    }
}