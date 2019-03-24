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

    public static void main(String[] args) {
//        List<Integer> answer = answerInit();
//        System.out.println(answer);
//        List<Integer> check = checkInit();
//        System.out.println(check.get(0));
//        System.out.println(check.get(1));

    }
}
