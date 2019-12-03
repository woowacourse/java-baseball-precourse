import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class BaseballGame {
    private static final Integer[] TARGET_INTEGERS = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    private static final int NUMBER_LENGTH = 3;
    public static final String MESSAGE_NOT_INTEGER = "정수가 아닙니다. 다시 입력해주세요.";
    public static final String MESSAGE_INCLUDE_ZERO = "0이 포함되어서는 안됩니다. 다시 입력해주세요.";
    public static final String MESSAGE_NOT_THREE_DIGITS = "세 자리 수가 아닙니다. 다시 입력해주세요.";
    public static final String MESSAGE_DUPLICATED_NUMBER = "중복된 숫자가 있습니다. 다시 입력해주세요.";
    public static final String MESSAGE_RESTART_OR_EXIT = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요";
    public static final String MESSAGE_INPUT_NUMBERS = "숫자를 입력해주세요 : ";
    public static final String MESSAGE_CLEAR = NUMBER_LENGTH + "개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final int STRIKES_INDEX = 0;
    public static final int BALLS_INDEX = 1;
    public static final String INPUT_NUMBER_DELIMITER = "";
    public static final int LIST_START_INDEX = 0;
    public static final String RESTART_INDEX = "1";
    public static final String EXIT_INDEX = "2";
    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        new BaseballGame();
    }

    public BaseballGame() {
        while (true) {
            playBaseball();
            if (!askReplay()) {
                break;
            }
        }
    }

    public void playBaseball() {
        List<Integer> computerNumber = generateComputerNumber();
        while (true) {
            List<Integer> userNumber = getUserNumber();
            int[] ballCount = computeCount(computerNumber, userNumber);
            printCount(ballCount);
            if (ballCount[STRIKES_INDEX] == NUMBER_LENGTH) {    // if all numbers are strikes break loop.
                System.out.println(MESSAGE_CLEAR);
                break;
            }
        }
    }

    private List<Integer> generateComputerNumber() {
        List<Integer> integerList = Arrays.asList(TARGET_INTEGERS);
        Collections.shuffle(integerList);
        return integerList.subList(LIST_START_INDEX, NUMBER_LENGTH);
    }

    private List<Integer> getUserNumber() {
        String inputNumber;
        while (true) {
            System.out.print(MESSAGE_INPUT_NUMBERS);
            inputNumber = scanner.next();
            if (validateUserNumber(inputNumber)) {
                break;
            }
        }
        List<Integer> userNumber = Stream
                .of(inputNumber.split(""))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
        return userNumber;
    }

    private boolean validateUserNumber(String inputNumber) {
        if (!validateInteger(inputNumber)) {
            return false;
        }
        if (!validateZero(inputNumber)) {
            return false;
        }
        if (!validateLength(inputNumber)) {
            return false;
        }
        if (!validateSameNumber(inputNumber)) {
            return false;
        }
        return true;
    }

    private boolean validateInteger(String inputNumber) {
        try {
            Integer.parseInt(inputNumber);
            return true;
        } catch (Exception e) {
            System.out.println(MESSAGE_NOT_INTEGER);
            return false;
        }
    }

    private boolean validateZero(String inputNumber) {
        if (Arrays.asList(inputNumber.split(INPUT_NUMBER_DELIMITER)).contains("0")) {
            System.out.println(MESSAGE_INCLUDE_ZERO);
            return false;
        } else {
            return true;
        }
    }

    private boolean validateLength(String inputNumber) {
        if (inputNumber.length() != NUMBER_LENGTH) {
            System.out.println(MESSAGE_NOT_THREE_DIGITS);
            return false;
        } else {
            return true;
        }
    }

    private boolean validateSameNumber(String inputNumber) {
        String[] number = inputNumber.split(INPUT_NUMBER_DELIMITER);
        Set<String> uniqueNumber = new HashSet<String>(Arrays.asList(number));
        if (uniqueNumber.size() < NUMBER_LENGTH) {
            System.out.println(MESSAGE_DUPLICATED_NUMBER);
            return false;
        } else {
            return true;
        }
    }

    private int[] computeCount(List<Integer> computerNumber, List<Integer> userNumber) {
        int strikes = computeStrikes(computerNumber, userNumber);
        int balls = computeBalls(computerNumber, userNumber);
        int[] ballCount = {strikes, balls};
        return ballCount;
    }

    private int computeStrikes(List<Integer> computerNumber, List<Integer> userNumber) {
        int strikes = 0;
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            if (computerNumber.get(i) == userNumber.get(i)) {
                strikes++;
            }
        }
        return strikes;
    }

    private int computeBalls(List<Integer> computerNumber, List<Integer> userNumber) {
        int balls = 0;
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            List<Integer> userNumberForBallCount = new ArrayList(userNumber);
            userNumberForBallCount.remove(i);
            if (userNumberForBallCount.contains(computerNumber.get(i))) {
                balls++;
            }
        }
        return balls;
    }

    private void printCount(int[] ballCount) {
        StringBuilder tellCount = new StringBuilder();
        if (ballCount[STRIKES_INDEX] == 0 && ballCount[BALLS_INDEX] == 0) {
            tellCount.append("낫싱");
        }
        if (ballCount[STRIKES_INDEX] > 0) {
            tellCount.append(ballCount[STRIKES_INDEX] + " 스트라이크 ");
        }
        if (ballCount[BALLS_INDEX] > 0) {
            tellCount.append(ballCount[BALLS_INDEX] + " 볼");
        }
        System.out.println(tellCount.toString());
    }

    private boolean askReplay() {
        while (true) {
            System.out.println(MESSAGE_RESTART_OR_EXIT);
            String inputNumber = scanner.next();
            if (inputNumber.equals(EXIT_INDEX)) {
                return false;
            } else if (inputNumber.equals(RESTART_INDEX)) {
                return true;
            }
        }
    }
}