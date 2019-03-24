import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BaseBall {

    private static List<Integer> answerInit() {
        List<Integer> arr = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            arr.add(i);
        }
        Collections.shuffle(arr);
        return arr.subList(0, 3);
    }

    private static List<Integer> checkInit() {
        List<Integer> check = new ArrayList<>();
        check.add(0);
        check.add(0);
        return check;
    }

    private static List<Integer> comparing(List<Integer> answer, List<Integer> user) {
        List<Integer> check = checkInit();
        for (int i = 0; i < 3; i ++) {
            if (answer.get(i).equals(user.get(i))) {
                int strike = check.get(0);
                strike += 1;
                check.set(0, strike);
            } else if (answer.contains(user.get(i))) {
                int ball = check.get(1);
                ball += 1;
                check.set(1, ball);
            }
        }
        return check;
    }

    private static void printResult(List<Integer> check) {
        int strike = check.get(0);
        int ball = check.get(1);
        if (strike > 0 && ball > 0) {
            System.out.printf("%d Strike, %d Ball\n", strike, ball);
        } else if (strike > 0) {
            System.out.printf("%d Strike\n", strike);
        } else if (ball > 0) {
            System.out.printf("%d Ball\n", ball);
        } else {
            System.out.println("Nothing");
        }
    }

    private static List<Integer> getUser(Scanner sc) {
        List<Integer> user = new ArrayList<>();
        int number = sc.nextInt();
        List<Integer> unit = new ArrayList<>();
        unit.add(100);
        unit.add(10);
        unit.add(1);
        for (int i = 0; i < 3; i++) {
            int quotient = number / unit.get(i);
            user.add(quotient);
            number %= unit.get(i);
        }
        return user;
    }

    private static void play(Scanner sc) {
        List<Integer> answer = answerInit();
        System.out.println(answer);
        while (true) {
            System.out.println("숫자를 입력해주세요");
            List<Integer> user = getUser(sc);
            List<Integer> check = comparing(answer, user);
            printResult(check);
            if (check.get(0) > 2) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            play(sc);
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            int game = sc.nextInt();
            if (game > 1) {
                break;
            }
        }

    }
}
