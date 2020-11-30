package baseball;

import utils.RandomUtils;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        baseballGame(scanner);
        scanner.close();
    }

    private static void baseballGame(Scanner kbd){
        boolean newgame = true;
        while(newgame) {
            int[] answerList = generateNumber();
            User user = new User();
            newgame = playGame(user, kbd, answerList);
        }
    }

    private static boolean playGame(User user, Scanner kbd, int[] answer) {
        boolean gameover = true;
        boolean newgame;
        while (gameover) {
            int[] guess = user.getGuess(kbd);
            gameover = calResult(answer, guess);
        }
        while (true) {
            try {
                newgame = checkGameState(kbd);
                break;
            } catch (Exception e) {
                System.out.println("1 또는 2만 입력가능합니다");
            }
        }
        return newgame;
    }

    private static int[] generateNumber() {
        /* 1~9의 서로 다른 수로 이루어진 3자리 난수 생성*/
        int[] answer = new int[3];
        while(answer[0] == answer[1] || answer[0] == answer[2] || answer[1] == answer[2]) {
            /* 중복된 숫자가 있을 경우 다시 생성*/
            answer[0] = RandomUtils.nextInt(1,9);
            answer[1] = RandomUtils.nextInt(1,9);
            answer[2] = RandomUtils.nextInt(1,9);
        }
        return answer;
    }

    private static boolean calResult(int[] answer, int[] guess) {
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < answer.length; i++) {
            if (guess[i] == answer[i]) strike++;
            if (guess[i] == answer[(i + 1) % 3] || guess[i] == answer[(i + 2) % 3])
                ball++;
        }
        return displayResultMessage(strike, ball);
    }

    private static boolean displayResultMessage(int strike, int ball) {
        if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return false;
        }
        else if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
            return true;
        }
        else {
            System.out.printf("%d볼 %d스트라이크\n", ball, strike);
            return true;
        }
    }

    private static boolean checkGameState(Scanner kbd) {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = kbd.next();
        int state = Integer.parseInt(input);
        if (state == 1) return true;
        else if (state == 2) return false;
        else throw new IllegalArgumentException();
    }
}