/*
 * Baseball
 *
 * ver 0.1 - 초안작성
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

    private static String makeAnswer() {
        String answer = "";

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

