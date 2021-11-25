package baseball;
import java.util.*;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;


public class BaseballGameApplication {

    public static final String GAME_START_MESSAGE = "숫자를 입력해주세요 : ";
    public static final String MESSAGE_ABOUT_WRONG_INPUT = "잘못된 입력입니다.";
    public static final String HINT_BALL_MESSAGE = "%d볼 ";
    public static final String HINT_STRIKE_MESSAGE = "%d스트라이크 ";
    public static final String HINT_NOTHING_MESSAGE = "낫싱";
    public static final String GAME_END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final String CHECK_KEEP_GOING_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public static final int LENGTH_OF_HINT = 3;
    public static final int LENGTH_OF_END_MESSAGE = 1;
    public static List<Integer> answerNumber = Randoms.pickUniqueNumbersInRange(1, 10, 3);
    public static boolean keep_playing_game = true;

    public static void main(String[] args) {
        while (keep_playing_game){
            String userInput;
            System.out.print(GAME_START_MESSAGE);
            userInput = Console.readLine();
            checkWrongInput(userInput, LENGTH_OF_HINT);
            giveResultMessage(userInput);
        }
    }

    public static void setAnswerNumber(){
        answerNumber = Randoms.pickUniqueNumbersInRange(1, 10, 3);
    }

    public static void checkWrongInput(String number, int limitLength){
        boolean isNumeric = number.matches("[+-]?\\d*(\\.\\d+)?");
        if (!isNumeric || number.length() != limitLength){
            throw new IllegalArgumentException(MESSAGE_ABOUT_WRONG_INPUT);
        }
    }

    public static void giveResultMessage(String number) {
        int[] info_ball_and_strike = compareNumber(number);
        if (info_ball_and_strike[0] > 0 && info_ball_and_strike[1] > 0){
            System.out.printf(HINT_BALL_MESSAGE, info_ball_and_strike[0]);
            System.out.printf(HINT_STRIKE_MESSAGE + '\n', info_ball_and_strike[1]);
        }
        else if (info_ball_and_strike[0] > 0){
            System.out.printf(HINT_BALL_MESSAGE + '\n', info_ball_and_strike[0]);
        }
        else if (info_ball_and_strike[1] > 0){
            System.out.printf(HINT_STRIKE_MESSAGE + '\n', info_ball_and_strike[1]);
        }
        else{
            System.out.println(HINT_NOTHING_MESSAGE);
        }
        if (checkGameEnd(info_ball_and_strike[1])){
            System.out.println(GAME_END_MESSAGE);
            checkKeepGoingGame();
        }
    }

    public static int[] compareNumber(String number){
        int ballNumber = 0;
        int strikeNumber = 0;
        for (int i=0; i<3; i++){
            strikeNumber += countStrikeNumber(answerNumber.get(i), Character.getNumericValue(number.charAt(i)));
            ballNumber += countBallNumber(i, Character.getNumericValue(number.charAt(i)));
        }
        return new int[] {ballNumber, strikeNumber};
    }

    public static int countStrikeNumber(int answer, int userInput){
        if (answer == userInput){
            return 1;
        }
        return 0;
    }

    public static int countBallNumber(int nthOrder , int user_input){
        if (answerNumber.contains(user_input) && answerNumber.get(nthOrder) != user_input)
        {
            return 1;
        }
        return 0;
    }

    public static boolean checkGameEnd(int strike_number){
        return strike_number==3;
    }

    public static void checkKeepGoingGame(){
        String user_answer;
        System.out.println(CHECK_KEEP_GOING_MESSAGE);
        user_answer = Console.readLine();
        checkWrongInput(user_answer, LENGTH_OF_END_MESSAGE);
        if (user_answer.equals("2")) {
            keep_playing_game = false;
            return;
        }
        if (user_answer.equals("1")){
            setAnswerNumber();
            return;
        }
        throw new IllegalArgumentException(MESSAGE_ABOUT_WRONG_INPUT);
    }
}
