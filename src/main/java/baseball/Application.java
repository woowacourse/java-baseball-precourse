package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        boolean isGameEnd = false;
        while (!isGameEnd) {
            List<Integer> computer = initComputerNumbers();
            boolean isUserInputEnd = false;
            while (!isUserInputEnd) {
                List<Integer> user = initUserNumbers();
                isUserInputEnd = isCheckLists(computer, user);
            }
            isGameEnd = isGameExit();
        }
    }

    private static List<Integer> initComputerNumbers() {
        List<Integer> list = new ArrayList<>();
        while (list.size() != 3) {
            int number = Randoms.pickNumberInRange(1, 9);
            if (!list.contains(number)) {
                list.add(number);
            }
        }
        return list;
    }

    private static List<Integer> initUserNumbers() {
        String userNumberStr = Console.readLine();
        checkUserNumberStr(userNumberStr);
        return userNumberStr
                .chars()
                .mapToObj(c -> c - '0')
                .collect(Collectors.toList());
    }

    private static void checkUserNumberStr(String userNumberStr) {
        if (userNumberStr.length() != 3)
            throw new IllegalArgumentException();
        long count = userNumberStr.chars()
                .filter(c -> '0' <= c && c <= '9')
                .count();
        if (count != 3)
            throw new IllegalArgumentException();
    }

    private static boolean isCheckLists(List<Integer> computer, List<Integer> user) {
        int strike = strike(computer, user);
        int ball = ball(computer, user);
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
            return false;
        }
        if (ball == 0) {
            System.out.printf("%d스트라이크\n", strike);
            return strike == 3;
        }
        if (strike == 0) {
            System.out.printf("%d볼\n", ball);
            return false;
        }
        System.out.printf("%d볼 %d스트라이크\n", ball, strike);
        return false;
    }

    private static int strike(List<Integer> computer, List<Integer> user) {
        int count = 0;
        for (int i = 0; i < computer.size(); i++) {
            if (computer.get(i).equals(user.get(i))) {
                count++;
            }
        }
        return count;
    }

    private static int ball(List<Integer> computer, List<Integer> user) {
        int count = 0;
        for (int i = 0; i < computer.size(); i++) {
            if (computer.contains(user.get(i)) && !computer.get(i).equals(user.get(i))) {
                count++;
            }
        }
        return count;
    }

    public static boolean isGameExit() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String exitStr = Console.readLine();
        checkGameExitStr(exitStr);
        return exitStr.equals("2");
    }

    private static void checkGameExitStr(String str) {
        if (str.equals("1") || str.equals("2")) {
            return;
        }
        throw new IllegalArgumentException();
    }
}
