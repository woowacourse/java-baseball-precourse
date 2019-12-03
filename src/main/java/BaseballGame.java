import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class BaseballGame {
    private static final Integer[] TARGET_INTEGERS = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    private static final int NUMBER_LENGTH = 3;

    public static void main(String[] args) {
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

    public static void playBaseball() {
        List<Integer> computerNumber = generateComputerNumber();
        while (true) {
            List<Integer> userNumber = getUserNumber();
            int[] ballCount = computeCount(computerNumber, userNumber);
            printCount(ballCount);
            if (ballCount[0] == NUMBER_LENGTH) {    // if all numbers are strikes break loop.
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }

    private static List<Integer> generateComputerNumber() {
        List<Integer> integerList = Arrays.asList(TARGET_INTEGERS);
        Collections.shuffle(integerList);
        List<Integer> slicedList = integerList.subList(0, NUMBER_LENGTH);
        return slicedList;
    }

    private static List<Integer> getUserNumber() {
        String inputNumber = "";
        while (true) {
            System.out.println("숫자를 입력해주세요");
            final Scanner scanner = new Scanner(System.in);
            inputNumber = scanner.next();
            if (validateUserNumber(inputNumber)) {
                break;
            }
        }
        List<Integer> userNumber = Stream.of(inputNumber.split("")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        return userNumber;
    }

    private static boolean validateUserNumber(String inputNumber) {
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

    private static boolean validateInteger(String inputNumber) {
        try {
            Integer.parseInt(inputNumber);
            return true;
        } catch (Exception e) {
            System.out.println("정수가 아닙니다. 다시 입력해주세요.");
            return false;
        }
    }

    private static boolean validateZero(String inputNumber) {
        if (Arrays.asList(inputNumber.split("")).contains("0")) {
            System.out.println("0이 포함되어서는 안됩니다. 다시 입력해주세요.");
            return false;
        } else {
            return true;
        }
    }

    private static boolean validateLength(String inputNumber) {
        if (inputNumber.length() != 3) {
            System.out.println("세 자리 수가 아닙니다. 다시 입력해주세요.");
            return false;
        } else {
            return true;
        }
    }

    private static boolean validateSameNumber(String inputNumber) {
        String[] number = inputNumber.split("");
        Set<String> uniqueNumber = new HashSet<String>(Arrays.asList(number));
        if (uniqueNumber.size() < 3) {
            System.out.println("중복된 숫자가 있습니다. 다시 입력해주세요.");
            return false;
        } else {
            return true;
        }
    }

    private static int[] computeCount(List<Integer> computerNumber, List<Integer> userNumber) {
        int strikes = computeStrikes(computerNumber, userNumber);
        int balls = computeBalls(computerNumber, userNumber);
        int[] ballCount = {strikes, balls};
        return ballCount;
    }

    private static int computeStrikes(List<Integer> computerNumber, List<Integer> userNumber) {
        int strikes = 0;
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            if (computerNumber.get(i) == userNumber.get(i)) {
                strikes++;
            }
        }
        return strikes;
    }

    private static int computeBalls(List<Integer> computerNumber, List<Integer> userNumber) {
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

    private static void printCount(int[] ballCount) {
        StringBuilder tellCount = new StringBuilder();
        if (ballCount[0] == 0 && ballCount[1] == 0) {
            tellCount.append("낫싱");
        }
        if (ballCount[0] > 0) {
            tellCount.append(ballCount[0] + " 스트라이크 ");
        }
        if (ballCount[1] > 0) {
            tellCount.append(ballCount[1] + " 볼");
        }
        System.out.println(tellCount.toString());
    }

    private static boolean askReplay() {
        while (true) {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
            final Scanner scanner = new Scanner(System.in);
            String inputNumber = scanner.next();
            if (inputNumber.equals("2")) {
                return false;
            } else if (inputNumber.equals("1")) {
                return true;
            }
        }
    }
}