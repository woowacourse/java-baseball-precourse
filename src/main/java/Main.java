import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    private static final int NUMS_MAX_LENGTH = 3;
    private static final int MAX_PICK_NUM = 9;
    private static final int MIN_PICK_NUM = 1;
    private static final int INVALID_VALUE = 0;
    private static final int NOT_MATCHED = 0;
    private static final int FULL_STRIKE_COUNT = NUMS_MAX_LENGTH;
    private static final String RESTART_GAME = "1";
    private static final String STOP_GAME = "2";

    private static ArrayList<Integer> pickComputerNums() {
        ArrayList<Integer> computerNums = new ArrayList<>();
        while (computerNums.size() < NUMS_MAX_LENGTH) {
            int num = (int)(Math.random()*MAX_PICK_NUM)+MIN_PICK_NUM;
            computerNums.add(num);
            if (isNotDuplicatedNums(computerNums)) {
                continue;
            }
            computerNums.remove(computerNums.size()-1);
        }
        return computerNums;
    }

    private static boolean isNotDuplicatedNums(ArrayList<Integer> numsList) {
        HashSet<Integer> numSet = new HashSet<>(numsList);
        return numSet.size() == numsList.size();
    }

    private static ArrayList<Integer> getUserNums() {
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            String userInput = getUserInput();
            String warningMessage = "★1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 입력해 주세요.";
            if (isNotThreeDigitNums(userInput)) {
                System.out.println(warningMessage);
                continue;
            }
            ArrayList<Integer> userNumsList = getUserNumsList(userInput);
            if (doesNotContainZero(userNumsList) && isNotDuplicatedNums(userNumsList)) {
                return userNumsList;
            }
            System.out.println(warningMessage);
        }
    }

    private static String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        return userInput;
    }

    private static ArrayList<Integer> getUserNumsList(String userInput) {
        ArrayList<Integer> userInputList = new ArrayList<>();
        for (int i=0; i<userInput.length(); i++) {
            int num = userInput.charAt(i) - '0';
            userInputList.add(num);
        }
        return userInputList;
    }

    private static boolean isNotThreeDigitNums(String userInput) {
        if (userInput.length() != NUMS_MAX_LENGTH) {
            return true;
        }
        for (int i=0; i<userInput.length(); i++) {
            char userInputChar = userInput.charAt(i);
            if (userInputChar < toCharacter(MIN_PICK_NUM) || toCharacter(MAX_PICK_NUM) < userInputChar) {
                return true;
            }
        }
        return false;
    }

    private static char toCharacter(int num) {
        return Character.forDigit(num, 10);
    }

    private static boolean doesNotContainZero(ArrayList<Integer> numsList) {
        for (int i=0; i<numsList.size(); i++) {
            int userNum = numsList.get(i);
            if (userNum == INVALID_VALUE) {
                return false;
            }
        }
        return true;
    }

    private static int countStrike(ArrayList<Integer> computerNums, ArrayList<Integer> userNums) {
        int strike = 0;
        for (int i=0; i<NUMS_MAX_LENGTH; i++) {
            int computerNum = computerNums.get(i);
            int userNum = userNums.get(i);
            if(Objects.equals(computerNum, userNum)) {
                strike++;
            }
        }
        return strike;
    }

    private static boolean isBall(int invalidIndex, int computerNum, ArrayList<Integer> userNums) {
        for (int i=0; i<NUMS_MAX_LENGTH; i++) {
            if (invalidIndex != i && computerNum == userNums.get(i)) {
                return true;
            }
        }
        return false;
    }

    private static int countBall(ArrayList<Integer> computerNums, ArrayList<Integer> userNums) {
        int ball = 0;
        for (int i=0; i<NUMS_MAX_LENGTH; i++) {
            if (isBall(i, computerNums.get(i), userNums)) {
                ball++;
            }
        }
        return ball;
    }

    private static void printScoreMessage(int strike, int ball) {
        if (strike == NOT_MATCHED && ball == NOT_MATCHED) {
            System.out.println("낫싱");
        }
        StringBuilder sb = new StringBuilder();
        if (strike != NOT_MATCHED) {
            sb.append(strike).append("스트라이크 ");
        }
        if (ball != NOT_MATCHED) {
            sb.append(ball).append("볼");
        }
        System.out.println(sb.toString().trim());
    }

    private static String getRequestNumber() {
        while (true) {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String requestNumber = getUserInput();
            if (requestNumber.equals(RESTART_GAME) || requestNumber.equals(STOP_GAME)) {
                return requestNumber;
            }
        }
    }

    private static void playGame() {
        ArrayList<Integer> computerNums = pickComputerNums();
        while (true) {
            ArrayList<Integer> userNums = getUserNums();
            int strikeCount = countStrike(computerNums, userNums);
            int ballCount = countBall(computerNums, userNums);
            printScoreMessage(strikeCount, ballCount);
            if (strikeCount == FULL_STRIKE_COUNT) {
                break;
            }
        }
        String overMessage = String.format("%d개의 숫자를 모두 맞히셨습니다! 게임 종료", NUMS_MAX_LENGTH);
        System.out.println(overMessage);
    }

    public static void main(String[] args) {
        while (true) {
            playGame();
            String requestNumber = getRequestNumber();
            if (requestNumber.equals(STOP_GAME)) {
                break;
            }
        }
    }
}
