import java.util.HashSet;
import java.util.Random;

/*
 * Baseball
 *
 * ver 0.2 - makeAnswer() 구현
 *
 * 2019.12.02
 */
public class Baseball {
    public static void main(String[] args) {
        String answer = "";
        String numbers = "";
        // 게임진행
        do {
            answer = makeAnswer();
            // 3 스트라이크가 나올 때까지 반복
            do {
                numbers = inputNumbers();
            } while (checkedNumbers(numbers, answer));
        } while (restart());
    }

    // 1 ~ 9까지 서로 다른 임의의 수 3자리를 생성
    private static String makeAnswer() {
        String answer = "";
        Random rd = new Random();
        HashSet<Integer> hs = new HashSet<Integer>();
        while (hs.size() < 3) {
            hs.add(rd.nextInt(8) + 1);
        }
        for (int i : hs) {
            answer += i;
        }
        return answer;
    }

    private static String inputNumbers() {
        String numbers = "";

        return numbers;
    }

    private static boolean checkedNumbers(String numbers, String answer) {
        boolean recheck = false;

        return recheck;
    }

    private static boolean restart() {
        boolean restart = false;

        return restart;
    }
}

