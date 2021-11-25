package baseball;
import java.util.*;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;


public class Application {

    public static final String START_MESSAGE = "숫자를 입력해주세요 : ";
    public static final String MESSAGE_ABOUT_WRONG_INPUT = "잘못된 입력입니다.";
    public static final String HINT_MESSAGE = "%d볼 %d스트라이크";
    public static final int LENGTH_OF_ANSWER = 3;

    public static List<Integer> answerNumber = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            setAnswerNumber(); // 정답 설정 부분
            String number;
            System.out.print(START_MESSAGE);
            number = Console.readLine();
            checkWrongInput(number);
            giveHintMessage(number);
        }
    }

    public static void setAnswerNumber(){
        answerNumber = Randoms.pickUniqueNumbersInRange(1, 10, 3);
    }

    public static void checkWrongInput(String number){
        boolean isNumeric = number.matches("[+-]?\\d*(\\.\\d+)?");
        if (!isNumeric || number.length() != LENGTH_OF_ANSWER){
            throw new IllegalArgumentException(MESSAGE_ABOUT_WRONG_INPUT);
        }
    }

    public static void giveHintMessage(String number) {
        int[] info_hint = compareNumber(number);

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

    public static int countStrikeNumber(int answer, int user_input){
        if (answer == user_input){
            return 1;
        }
        return 0;
    }

    public static int countBallNumber(int nth_order , int user_input){
        if (answerNumber.contains(user_input) && answerNumber.get(nth_order) != user_input)
        {
            return 1;
        }
        return 0;
    }

}
