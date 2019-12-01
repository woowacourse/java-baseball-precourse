import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    private static final int NUMS_MAX_LENGTH = 3;
    private static final int MAX_PICK_NUM = 9;
    private static final int MIN_PICK_NUM = 1;
    private static final int INVALID_VALUE = 0;

    private static ArrayList<Integer> pickComputerNums() {
        ArrayList<Integer> computerNums = new ArrayList<>();
        while (computerNums.size() < NUMS_MAX_LENGTH) {
            int num = (int)(Math.random()*MAX_PICK_NUM)+MIN_PICK_NUM;
            if (isDuplicatedNum(num, computerNums)) {
                continue;
            }
            computerNums.add(num);
        }
        return computerNums;
    }

    private static boolean isDuplicatedNum(int num, ArrayList<Integer> numsList) {
        for (int i=0; i<numsList.size(); i++) {
            if (num == numsList.get(i)) {
                return true;
            }
        }
        return false;
    }

    private static ArrayList<Integer> getUserNums() {
        while (true) {
            String userInput = getUserInput();
            if (isThreeDigitNums(userInput) && doesNotContainZero(userInput) && isNotDuplicatedNums(userInput)) {
                return getUserNumsList(userInput);
            }
            System.out.println("★1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 입력해 주세요.");
        }
    }

    private static String getUserInput() {
        System.out.print("숫자를 입력해주세요 : ");
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

    private static boolean isThreeDigitNums(String userInput) {
        if (userInput.length() != NUMS_MAX_LENGTH) {
            return false;
        }

        for (int i=0; i<userInput.length(); i++) {
            char userInputCh = userInput.charAt(i);
            if (userInputCh < toCharacter(MIN_PICK_NUM) || toCharacter(MAX_PICK_NUM) < userInputCh) {
                return false;
            }
        }
        return true;
    }

    private static char toCharacter(int num) {
        return Character.forDigit(num, 10);
    }

    private static boolean doesNotContainZero(String userInput) {
        for (int i=0; i<userInput.length(); i++) {
            if (userInput.charAt(i) == toCharacter(INVALID_VALUE)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isNotDuplicatedNums(String userInput) {
        HashSet<Character> numSet = new HashSet<>();
        for (int i=0; i<userInput.length(); i++) {
            numSet.add(userInput.charAt(i));
        }
        return numSet.size() == NUMS_MAX_LENGTH;
    }

    public static void main(String[] args) {
        System.out.println(pickComputerNums());
    }
}
