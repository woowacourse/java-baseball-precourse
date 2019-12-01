import java.sql.SQLOutput;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

/*
 * Baseball
 *
 * ver 0.4 - checkedNumbers(String numbers, String answer) 구현
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
        boolean re = false;
        Scanner sc = new Scanner(System.in);
        do {
            re = false;
            // 이 부분에서 print로 하면 인텔리j + gradle인 환경에서 출력이 먼저 나오지 않고 do-while 탈출 후 출력이 됨. 해당 부분 왜인지 나중에 확인해보자.
            System.out.println("1 ~ 9까지 서로 다른 수로 이뤄진 3자리 수로 입력해주세요 : ");
            numbers = sc.next();
            if (numbers.length() != 3
                    || numbers.charAt(0) == numbers.charAt(1)
                    || numbers.charAt(0) == numbers.charAt(2)
                    || numbers.charAt(1) == numbers.charAt(2)) {
                re = true;
            }
        } while (re);
        return numbers;
    }

    private static boolean checkedNumbers(String numbers, String answer) {
        boolean recheck = true;
        if (numbers.equals(answer)) {
            recheck = false;
        }
        return recheck;
    }

    private static boolean restart() {
        boolean restart = false;

        return restart;
    }
}

