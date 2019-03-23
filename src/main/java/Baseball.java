import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

class Game {
    private char[] answer;

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
        int[] bs = {0, 0}; // {ball, strike}
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

    public boolean checkAnswer(int[] checkNum) {
        if (checkNum[1] == 3) {
            return true;
        } else {
            return false;
        }
    }

    public void print(int[] checkNum) {
        String response = "";

        if (checkNum[1] != 0) {
            response += checkNum[1] + " 스트라이크 ";
        }
        if (checkNum[0] != 0) {
            response += checkNum[0] + " 볼";
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
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Game game = new Game();
        String[] numArr;
        int[] checkNum;
        boolean flag = false; // 정답인지 확인을 하기 위해

        while (!flag) {
            // 입력한 숫자가 3자리일 때 + 0이 포함 안 된 경우
            do {
                System.out.print("숫자를 입력해주세요: ");
                numArr = input.next().split("");
            } while (!(numArr.length == 3) || (Arrays.toString(numArr).contains("0")));

            checkNum = game.compareAnswer(numArr);
            flag = game.checkAnswer(checkNum);
            game.print(checkNum);

            if (flag) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

                int temp = input.nextInt();
                flag = game.exitGame(temp);
            }
        }
    }
}
