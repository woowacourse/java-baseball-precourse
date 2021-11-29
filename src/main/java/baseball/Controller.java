package baseball;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Controller {
    private final static String REQUEST_INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private final static String RESTART_GAME_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n";
    private final static String ALL_STRIKE_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n";

    private final static String ZERO_TEXT = "0";
    private final static String RESUME_NUMBER = "1";
    private final static String QUIT_NUMBER = "2";

    private final static String STRIKE_TEXT = "스트라이크 ";
    private final static String BALL_TEXT = "볼 ";
    private final static String NOTHING_TEXT = "낫싱 ";

    private final static int BALL_TOTAL_NUMBER = 3;
    private final static int MINIMUM_NUMBER = 1;
    private final static int MAXIMUM_NUMBER = 9;

    private final static int STRIKE_COUNT_INDEX = 2;
    private final static int BALL_COUNT_INDEX = 1;
    private final static int NOTHING_COUNT_INDEX = 0;

    private static Player player1;
    private static Player player2;

    Controller() {
        player1 = new Player(); // 컴퓨터의 숫자
        player2 = new Player(); // 유저의 숫자
    }

    // 정답 숫자를 뽑는다. 이때 뽑은 숫자들이 서로 다른 1부터 9까지의 숫자일 때까지 과정을 반복한다.
    public static void startGame(){
        List<Integer> answerNumbersList;
        String answerNumbersString;

        do {
            answerNumbersList = getAnswer();
            answerNumbersString = Converter.makeListToString(answerNumbersList);
        } while (!checkInput(answerNumbersString));

        player1.setNumbersList(answerNumbersList);
    }

    // 사용자로부터 값을 입력받고, 힌트를 출력한다. 그리고 정답 여부를 반환한다.
    public static boolean processGame(){
        Message.printMessage(REQUEST_INPUT_MESSAGE);
        String inputMessage = Message.getMessage();

        if (!checkInput(inputMessage)) {
            throw new IllegalArgumentException("invalid value.");
        }

        player2.setNumbersList(Converter.makeInputToList(inputMessage));

        int[] comparisonResult = compareNumbersList(player1.getNumbersList(), player2.getNumbersList());
        String hintMessage = getHintMessage(comparisonResult);

        Message.printMessage(hintMessage);

        return isAllNumbersCorrect(hintMessage);
    }

    // 정답 숫자를 만든다.
    public static List<Integer> getAnswer(){
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < 3; i++){
            list.add(pickNumberInRange(MINIMUM_NUMBER, MAXIMUM_NUMBER));
        }
        return list;
    }

    // 입력값이 모든 검사를 통과했는지 알려준다.
    public static boolean checkInput(String inputString){
        return validateType(inputString) && validateRange(inputString) && validateNumber(inputString);
    }

    // 입력값에 문자가 포함되어 있는지 확인한다.
    public static boolean validateType(String inputString) {
        try {
            Integer.parseInt(inputString);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // 입력값의 각 자리가 1부터 9까지인지 확인한다.
    public static boolean validateRange(String inputString) {
        if(inputString.contains(ZERO_TEXT)) {
            return false;
        } else {
            return true;
        }
    }

    // 입력값이 서로 다른 3개의 숫자인지 확인한다.
    public static boolean validateNumber(String inputString){
        if(inputString.length() != BALL_TOTAL_NUMBER
                || Arrays.stream(inputString.split("")).distinct().count() != BALL_TOTAL_NUMBER){
            return false;
        } else {
            return true;
        }
    }

    // list1(정답 리스트)을 기준으로 두 리스트를 비교한다.
    public static int[] compareNumbersList(List<Integer> list1, List<Integer> list2){
        int[] result = new int[BALL_TOTAL_NUMBER];
        for(int i = 0; i < BALL_TOTAL_NUMBER; i++) {
            int num = list1.get(i);
            if (num == list2.get(i)) {
                result[STRIKE_COUNT_INDEX] ++;
            }else if (list2.contains(num)) {
                result[BALL_COUNT_INDEX] ++;
            }else {
                result[NOTHING_COUNT_INDEX] ++;
            }
        }
        return result;
    }

    // 비교 결과를 바탕으로 힌트 메시지를 작성한다.
    public static String getHintMessage(int[] result){
        StringBuilder stringBuilder = new StringBuilder();
        if (result[NOTHING_COUNT_INDEX] == BALL_TOTAL_NUMBER) {
            stringBuilder.append(NOTHING_TEXT);
        } else {
            if (result[BALL_COUNT_INDEX] != 0) {
                stringBuilder.append(result[BALL_COUNT_INDEX] + BALL_TEXT);
            }
            if (result[STRIKE_COUNT_INDEX] != 0) {
                stringBuilder.append(result[STRIKE_COUNT_INDEX] + STRIKE_TEXT);
            }
        }
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }

    // 3스트라이크인지 검사한다.
    public static boolean isAllNumbersCorrect(String hint){
        if(hint.contains(BALL_TOTAL_NUMBER + STRIKE_TEXT)){
            Message.printMessage(ALL_STRIKE_MESSAGE);
            return true;
        }
        return false;
    }

    // 3스트라이크일 때 게임을 끝낼 것인지 확인한다.
    public static boolean finishOrNot(){
        Message.printMessage(RESTART_GAME_MESSAGE);
        String input = Message.getMessage();
        if (input.equals(QUIT_NUMBER)) {
            return true;
        } else if (input.equals(RESUME_NUMBER)) {
            return false;
        } else {
            throw new IllegalArgumentException();
        }
    }
}
