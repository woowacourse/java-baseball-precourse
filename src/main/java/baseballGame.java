import java.util.Random;
import java.util.Arrays;
import java.util.Scanner;

public class baseballGame {
    int numbers[];
    Scanner scan;

    public void baseballNumber() {
        numbers = new int[3];
        this.game();
    }

    public void game() {
        scan = new Scanner(System.in);
        boolean judge = false;
        this.setNumbers();
        while (!judge) {
            System.out.print("숫자를 입력해주세요 : ");
            String meg = scan.next();
            int [] inputInt =  Arrays.stream(meg.split("")).mapToInt(Integer::parseInt).toArray();
            judge = this.numberCheck(this.numbers, inputInt);
            if (judge) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                int answer = scan.nextInt();
                if (answer == 1) {
                    judge = false;
                    this.setNumbers();
                }
            }
        }
    }

    public boolean numberCheck(int[] x, int[] y) {
        boolean endGame = false;
        String result = "";
        int strikeInt =  this.strikeCheck(x, y);
        int ballInt = this.ballCheck(x, y) - strikeInt;
        if (strikeInt > 0) {
            result += Integer.toString(strikeInt) + "스트라이크 ";
        }
        if (ballInt > 0) {
            result += Integer.toString(ballInt) + "볼 ";
        }
        if (result.length() == 0) {
            result += "낫싱";
        }
        System.out.println(Arrays.toString(x));
        System.out.println(Arrays.toString(y));
        System.out.println(result);
        if (strikeInt == 3) {
            endGame = true;
        }
        return endGame;
    }

    public int strikeCheck(int[] x, int[] y) {
        int cnt = 0;
        for (int i = 0; i < 3; i++) {
            if (x[i] == y[i]) {
                cnt++;
            }
        }
        return cnt;
    }

    public int ballCheck(int[] x, int[] y) {
        int cnt = 0;
        for (int i = 0; i < 3; i++) {
            int comp = y[i];
            if (Arrays.stream(x).anyMatch(a -> a == comp)) {
                cnt++;
            }
        }
        return cnt;
    }

    public void setNumbers() {
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            int num = random.nextInt(9) + 1;
            if (!Arrays.stream(numbers).anyMatch(x -> x == num)) {
                numbers[i] = num;
            } else {
                i--;
            }
        }
    }
}