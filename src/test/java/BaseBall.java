import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
            System.out.printf("%d Strike, %d Ball", strike, ball);
        } else if (strike > 0) {
            System.out.printf("%d Strike", strike);
        } else if (ball > 0) {
            System.out.printf("%d Ball", ball);
        } else {
            System.out.println("Nothing");
        }
    }

    public static void main(String[] args) {
//        List<Integer> answer = answerInit();
//        System.out.println(answer);
//        List<Integer> check = checkInit();
//        System.out.println(check.get(0));
//        System.out.println(check.get(1));
//        List<Integer> user = answerInit();
//        System.out.println(user);
//        List<Integer> result = comparing(answer, user);
//        System.out.println(result);
//        printResult(check);
    }
}
