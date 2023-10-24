package baseball;

import static constants.BaseballMessage.*;

import java.util.List;



public class BaseBallPlay {

    StringBuilder checkMessage = new StringBuilder();

    private String Correctanswercheck (int strike, int ball) {

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