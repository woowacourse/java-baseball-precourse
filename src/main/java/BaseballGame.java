import java.util.Random;
import java.util.Arrays;
import java.util.Scanner;

public class BaseballGame {
    private int[] numbers = new int[3];
    private Scanner scan = new Scanner(System.in);;

    public void baseballNumber() {
        String answer = "1";
        while (answer.equals("1")) {
            game();
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            answer = scan.nextLine();
        }
    }

    private void game() {
        boolean judge = false;
        this.setNumbers();
        while (!judge) {
            System.out.print("숫자를 입력해주세요 : ");
            String meg = scan.nextLine();
            if (is3Check(meg) && isNumber(meg)) {
                int [] inputInt =  Arrays.stream(meg.split("")).mapToInt(Integer::parseInt).toArray();
                judge = numberCheck(this.numbers, inputInt);
            }
        }
    }

    private boolean is3Check(String value) {
        if (value.length() == 3) {
            return true;
        }
        System.out.println("잘못된 입력입니다. 띄어쓰기없이 3개의 숫자만 입력해주세요.");
        return false;
    }

    private boolean isNumber(String value) {
        for (char c : value.toCharArray()) {
            if (c < 49 || c > 57) {
                System.out.println("잘못된 입력입니다. 띄어쓰기없이 3개의 숫자만 입력해주세요.");
                return false;
            }
        }
        return true;
    }

    private boolean numberCheck(int[] x, int[] y) {
        boolean endGame = false;
        String result = "";
        int strikeInt =  strikeCheck(x, y);
        int ballInt = ballCheck(x, y) - strikeInt;

        if (strikeInt > 0) {
            result += Integer.toString(strikeInt) + "스트라이크 ";
        }

        if (ballInt > 0) {
            result += Integer.toString(ballInt) + "볼 ";
        }

        if (result.length() == 0) {
            result = "낫싱";
        }

        System.out.println(result);
        if (strikeInt == 3) {
            endGame = true;
        }

        return endGame;
    }

    private  int strikeCheck(int[] x, int[] y) {
        int cnt = 0;
        for (int i = 0; i < 3; i++) {
            if (x[i] == y[i]) {
                cnt++;
            }
        }
        return cnt;
    }

    private int ballCheck(int[] x, int[] y) {
        int cnt = 0;
        for (int i = 0; i < 3; i++) {
            int comp = y[i];
            if (Arrays.stream(x).anyMatch(a -> a == comp)) {
                cnt++;
            }
        }
        return cnt;
    }

    private void setNumbers() {
        Random random = new Random();
        int i = 0;
        while (i != 3) {
            int num = random.nextInt(9) + 1;
            if (!Arrays.stream(numbers).anyMatch(x -> x == num)) {
                numbers[i] = num;
                i++;
            }
        }
    }
}