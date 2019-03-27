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

        int strike = 0;
        int ball = 0;
        while (strike != 3) {
            int[] user = getCorrectUserInput();

            strike = countStrikes(com, user);
            ball = countBalls(com, user);

            if ((strike == 0) && (ball == 0)) {
                System.out.println("낫싱");
                continue;
            }

            if (strike != 0) {
                System.out.print(strike + " 스트라이크 ");
            }
            if (ball != 0) {
                System.out.print(ball + " 볼 ");
            }
            System.out.println();
        }

        System.out.print(COUNT_OF_NUMBERS + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
        pause();
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

    public int countStrikes(int[] com, int[] user) {
        int ret = (com[0] == user[0]) ? 1 : 0;

        // base case
        if (user.length == 1) {
            return ret;
        }

        int[] subCom = Arrays.copyOfRange(com, 1, com.length);
        int[] subUser = Arrays.copyOfRange(user, 1, user.length);

        return ret + countStrikes(subCom, subUser);
    }

    public int countBalls(int[] com, int[] user) {
        int ret = 0;
        for (int i = 0; i < com.length; i++) {
            if ((com[i] == user[0]) && (i != com.length - user.length)) {
                ret = 1;
                break;
            }
        }

        // base case
        if (user.length == 1) {
            return ret;
        }

        int[] subUser = Arrays.copyOfRange(user, 1, user.length);

        return ret + countBalls(com, subUser);
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
