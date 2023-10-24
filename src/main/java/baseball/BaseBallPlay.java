package baseball;

import static constants.BaseballMessage.*;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;


public class BaseBallPlay {

    static StringBuilder checkMessage = new StringBuilder();
    private static List<Integer> computer = new ArrayList<>();
    private static List<Integer> player = new ArrayList<>();
    private static boolean endFlag = false;

    public static void gameStart() {
        computer = Number.setComputerRandomNumbers();
        while (!endFlag) {
            player = Number.getUserNumber();
            printAnswerCheck(computer, player);
        }
    }

    private static void printAnswerCheck(List<Integer> computer, List<Integer> player) {
        int strike = countStrike(computer, player);
        int ball = countBall(computer, player);

        System.out.println(correctAnswerCheck(strike, ball));
        if(strike == 3) {
            System.out.println(GAME_SUCCESS_MESSAGE);
            setRestartOrExit();
        }
    }

    private static String inputRestartOrExit() {
        System.out.println(GAME_RESTART_OR_END_MESSAGE);
        String endMessage = Console.readLine();
        if(!isSelectMessage(endMessage)) {
            throw new IllegalArgumentException();
        }
        return endMessage;
    }

    private static void setRestartOrExit() {
        String endpoint = inputRestartOrExit();
        if(endpoint.equals(1)) {
            computer = Number.setComputerRandomNumbers();
            return;
        }
        endFlag = true;
    }

    private static boolean isSelectMessage(String input) {
        Pattern pattern = Pattern.compile("[1-2]");
        return pattern.matcher(input).matches();
    }

    private static String correctAnswerCheck(int strike, int ball) {

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

    private static String MessageBallStrikeAppend(int ball, int strike){
        checkMessage.append(ball).append(BALL).append(strike).append(STRIKE).append("\n");
        return checkMessage.toString();
    }

    private static String MessageBallAppend(int ball){
        checkMessage.append(ball).append(BALL).append("\n");
        return checkMessage.toString();
    }

    private static String MessageStrikeAppend(int strike){
        checkMessage.append(strike).append(STRIKE).append("\n");
        return checkMessage.toString();
    }

    private static String MessageNothingAppend(){
        checkMessage.append(NOTHING);
        return checkMessage.toString();
    }

    private static int countStrike(List<Integer> answer, List<Integer> userinput) {
        int strike = 0;
        for (int idx = 0; idx < answer.size(); idx++) {
            if(answer.get(idx).equals(userinput.get(idx))) {
                strike++;
            }
        }
        return strike;
    }

    private static int countBall(List<Integer> answer, List<Integer> userinput) {
        int ballcount = 0;
        for(int idx = 0; idx < answer.size(); idx++) {
            if(!answer.get(idx).equals(userinput.get(idx)) && userinput.contains(answer.get(idx))) {
                ballcount++;
            }
        }
        return ballcount;
    }
}