import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;


public class Main {

        public static void main(String args[]) throws IOException {
                boolean gameContinue = true;

                while (gameContinue) {
                        playBaseball();
                        gameContinue = isRegame();
                }
        }

        public static boolean isDuplicate(int[] computerNumber, int i) {
                for (int j = 0; j < i; j++) {
                        if (computerNumber[i] == computerNumber[j]) {
                                return true;
                        }
                }
                return false;
        }

        public static int[] createRandomNumber() {
                Random rand = new Random();
                int[] computerNumber = new int[3];
                for (int i = 0; i < 3; i++) {
                        computerNumber[i] = rand.nextInt(9) + 1; // [1-9]
                        if (isDuplicate(computerNumber, i)) {
                                i--;
                        }
                }
                return computerNumber;
        }

        public static int[] input() throws IOException {
                boolean valid = false;
                String num = "";
                while (!valid) {
                        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
                        System.out.print("숫자를 입력해주세요 : ");
                        num = bf.readLine();
                        valid = isValid(num);
                }
                int[] userNumber = new int[3];
                for (int i = 0; i < 3; i++) {
                        userNumber[i] = num.charAt(i) - '0';
                }

                return userNumber;
        }

        public static void playBaseball() throws IOException {
                boolean success = false;
                int[] computerNumber = createRandomNumber();
                int[] userNumber;
                int strike, ball;
                while (!success) {
                        userNumber = input();
                        ball = countBall(computerNumber, userNumber);
                        strike = countStrike(computerNumber, userNumber);
                        if (strike == 0 && ball == 0) {
                                System.out.println("낫싱");
                        } else if (strike == 3) {
                                output();
                                success = true;
                        } else {
                                output(strike, ball);
                        }
                }

        }

        public static int countBall(int[] computerNum, int[] userNum) {
                int ball = 0;
                /*
                for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 3; j++) {
                                if (i != j) {
                                        if (computerNum[i] == userNum[j]) {
                                                ball++;
                                        }
                                }
                        }
                }
                 depth가 커지고, 기능을 나누기에는 애매해서 밑의 방식으로 만듬.
                 */
                if (computerNum[0] == userNum[1] || computerNum[0] == userNum[2]) {
                        ball++;
                }
                if (computerNum[1] == userNum[0] || computerNum[1] == userNum[2]) {
                        ball++;
                }
                if (computerNum[2] == userNum[0] || computerNum[2] == userNum[1]) {
                        ball++;
                }

                return ball;
        }

        public static int countStrike(int[] computerNum, int[] userNum) {
                int strike = 0;

                for (int i = 0; i < 3; i++) {
                        if (computerNum[i] == userNum[i]) strike++;
                }

                return strike;
        }

        public static void output(int strike, int ball) {
                if (ball == 0) {
                        System.out.println(strike + " 스트라이크");
                } else if (strike == 0) {
                        System.out.println(ball + "볼");
                } else {
                        System.out.println(strike + " 스트라이크 " + ball + "볼");
                }
        }

        public static void output() {
                System.out.println("3 스트라이크");
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
        }

        public static boolean isRegame() throws IOException {
                boolean check = true;
                int temp;
                while (check) {
                        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
                        String str = bf.readLine();
                        try {
                                temp = Integer.parseInt(str);
                        } catch (NumberFormatException e) {
                                System.out.println("잘못된 형식입니다.");
                                temp = 0;
                        }
                        if (temp == 2) {
                                return false;
                        } else if (temp == 1) {
                                return true;
                        } else {
                                System.out.println("1과 2중에서 다시 선택해주세요.");
                        }
                }
                return true;
        }

        public static boolean isValid(String inputNum) {

                if (inputNum.length() != 3) {
                        System.out.println("숫자를 3자리로 맞춰주세요.");
                        return false;
                }

                if (inputNum.charAt(0) == inputNum.charAt(1) || inputNum.charAt(0) == inputNum.charAt(2) || inputNum.charAt(1) == inputNum.charAt(2)) {
                        System.out.println("서로 다른 숫자를 입력해야 합니다.");
                        return false;
                }

                try {
                        Integer.parseInt(inputNum);
                } catch (NumberFormatException e) {
                        System.out.println("잘못된 형식입니다.");
                        return false;
                }

                return true;
        }
}
