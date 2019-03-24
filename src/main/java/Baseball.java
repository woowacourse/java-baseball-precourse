import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

class Game {
    private char[] answer;
    private int[] bs; // {ball, strike}

    public Game() {
        answer = generateAnswer();
    }

    private char[] generateAnswer() {
        Random random = new Random();
        char[] str = new char[3];
        int[] randomCheck = new int[9];

        int i = 0;
        while (i < str.length) {
            int num = random.nextInt(9) + 1;

            if (randomCheck[num - 1] != 1) {
                str[i] = (char) (num + '0');
                randomCheck[num - 1]++;
                i++;
            }
        }

        return str;
    }

    public int[] compareAnswer(String[] question) {
        bs = new int[2]; 
        String str = String.valueOf(answer);
        int i = 0;

        for (String e : question) {
            if (!str.contains(e)) {
                continue;
            }

            if (answer[i++] == e.charAt(0)) {
                bs[1]++; // strike 증가
            } else {
                bs[0]++; // ball 증가
            }
        }

        return bs;
    }

    public boolean checkAnswer() {
        if (bs[1] == 3) {
            return true;
        } else {
            return false;
        }
    }

    public void print() {
        String response = "";

        if (bs[1] != 0) {
            response += bs[1] + " 스트라이크 ";
        }
        if (bs[0] != 0) {
            response += bs[0] + " 볼";
        }

        if (response.equals("")) {
            response += "낫싱";
        }

        System.out.println(response);
    }

    public boolean exitGame(int temp) {
        if (temp == 1) {
            answer = generateAnswer();
            return false;
        } else {
            return true;
        }
    }
}

public class Baseball {

    public static boolean validInput(String[] numArr) {
        // 입력값이 3자리인지
        if (!(numArr.length == 3)) {
            return false;
        }

        // 입력값에 0이 포함이 되어 있는지
        if (Arrays.toString(numArr).contains("0")) {
            return false;
        }

        // 입력값이 숫자로 입력했는지
        try {
            for (String num : numArr) {
                Integer.parseInt(num);
            }
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Game game = new Game();
        String[] numArr;
        boolean flag = false; // while문을 탈출하기 위한 변수

        while (!flag) {
            do {
                System.out.print("숫자를 입력해주세요: ");
                numArr = input.next().split("");
            } while (!validInput(numArr));

            game.compareAnswer(numArr);
            flag = game.checkAnswer();
            game.print();

            if (flag) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

                int temp = input.nextInt();
                flag = game.exitGame(temp);
            }
        }
    }
}
