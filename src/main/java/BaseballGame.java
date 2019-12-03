import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BaseballGame {
    private static final Integer[] TARGET_INTEGERS = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    private static final int numberLength = 3;

    public static void main(String[] args) {
        System.out.println("숫자를 입력해주세요 ");
        List<Integer> computerNumber = generateComputerNumber();
        List<Integer> userNumber = getUserNumber();
        int[] ballCount = computeCount(computerNumber, userNumber);
        printCount(ballCount);
    }

    private static List<Integer> generateComputerNumber() {
        List<Integer> integerList = Arrays.asList(TARGET_INTEGERS);
        Collections.shuffle(integerList);
        List<Integer> slicedList = integerList.subList(0, numberLength);
        return slicedList;
    }

    private static List<Integer> getUserNumber() {
        String inputNumber = "";
        final Scanner scanner = new Scanner(System.in);
        inputNumber = scanner.next();
        validateInteger(inputNumber);
        validateZero(inputNumber);
        validateLength(inputNumber);
        validateSameNumber(inputNumber);
        List<Integer> userNumber = Stream.of(inputNumber.split("")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        return userNumber;
    }

    private static boolean validateUserNumber(String inputNumber) {
        if (validateInteger(inputNumber) == false) {
            return false;
        }
        if (validateZero(inputNumber) == false) {
            return false;
        }
        if (validateLength(inputNumber) == false) {
            return false;
        }
        if (validateSameNumber(inputNumber) == false) {
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
        for (int i = 0; i < numberLength; i++) {
            if (computerNumber.get(i) == userNumber.get(i)) {
                strikes++;
            }
        }
        return strikes;
    }

    private static int computeBalls(List<Integer> computerNumber, List<Integer> userNumber) {
        int balls = 0;
        for (int i = 0; i < numberLength; i++) {
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

}
