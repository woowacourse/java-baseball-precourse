package baseball;

import java.io.IOException;
import java.util.*;

public class Baseball {
    private static final String FIRST_SELECTION = "1";
    private static final int COUNT_OF_NUMBERS = 3;
    private Scanner scan;

    public Baseball() {
        scan = new Scanner(System.in);

        menu();
    }

    public void menu() {
        String sel = FIRST_SELECTION;

        Loop: while (true) {
            switch (sel) {
            case "1":
                startGame();
                break;
            case "2":
                System.out.print("프로그램이 종료됩니다. ");
                pause();
                break Loop;
            default:
                System.out.println("잘못 입력하셨습니다.");
            }

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            sel = scan.next();
        }

        scan.close();
    }

    public void startGame() {
        int[] com = generateComNumbers();

        while (true) {
            int[] user = getCorrectUserInput();

        }
    }

    public int[] generateComNumbers() {
        Set<Integer> set = new LinkedHashSet<>();

        while (set.size() != COUNT_OF_NUMBERS) {
            set.add((int) (Math.random() * 9 + 1));
        }

        Integer[] com = set.toArray(new Integer[set.size()]);
        return Arrays.stream(com).mapToInt(i->i).toArray();
    }

    public int[] getCorrectUserInput() {
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            String userInput = scan.next();

            // check user's input is integer
            if (!isInteger(userInput)) {
                System.out.println("잘못 입력하셨습니다. 숫자로 입력해주세요.");
                continue;
            }

            // check digits
            if (!isCorrectDigits(userInput)) {
                System.out.println("정답은 " + COUNT_OF_NUMBERS + "자리 정수입니다. 다시 입력해보세요.");
                continue;
            }

            // check user's input has zero
            if (hasZero(userInput)) {
                System.out.println("정답은 0을 포함하지 않습니다. 다시 입력해보세요.");
                continue;
            }

            // check user's input has duplicate numbers
            if (hasDuplicateCharacters(userInput)) {
                System.out.println("정답은 중복된 숫자가 없습니다. 다시 입력해보세요.");
                continue;
            }

            // generate user integer array from userInput
            int[] user = new int[COUNT_OF_NUMBERS];
            for (int i = 0; i < userInput.length(); i++) {
                user[i] = userInput.charAt(i) - '0';
            }
            return user;
        }
    }

    public boolean isInteger(String candidate) {
        try {
            Integer.parseInt(candidate);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public boolean isCorrectDigits(String userInput) {
        int digits = userInput.length();
        return (digits == COUNT_OF_NUMBERS);
    }

    public boolean hasZero(String candidate) {
        for (int i = 0; i < candidate.length(); i++) {
            if (candidate.charAt(i) == '0') {
                return true;
            }
        }
        return false;
    }

    public boolean hasDuplicateCharacters(String candidate) {
        // base case
        if (candidate.length() == 1) {
            return false;
        }

        char firstChar = candidate.charAt(0);
        for (int i = 1; i < candidate.length(); i++) {
            if (firstChar == candidate.charAt(i)) {
                return true;
            }
        }

        return hasDuplicateCharacters(candidate.substring(1));
    }

    public static void pause() {
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Baseball();
    }
}
