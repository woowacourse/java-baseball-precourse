package baseball;

import java.util.Scanner;
import java.util.Arrays;
import utils.RandomUtils;

public class GameComputer {
    final Scanner scanner = new Scanner(System.in);

    BallChoice computerChoice;

    public GameComputer() {
        computerChoice = new BallChoice();
        computerChoice.choice = chooseChoice();
    }

    public static String chooseChoice() {
        String computerChoice;
        int[] answer = new int[BallChoice.CHOICE_SIZE];

        answer[0] = RandomUtils.nextInt(1,9);
        do {
            answer[1] = RandomUtils.nextInt(1,9);
        } while (answer[0] == answer[1]);
        do {
            answer[2] = RandomUtils.nextInt(1,9);
        } while (answer[0] == answer[2] || answer[1] == answer[2]);
        computerChoice = Arrays.toString(answer).replaceAll("[^0-9]","");
        return computerChoice;
    }

    static boolean startGame(String computerChoice) {
        GamePlayer player = new GamePlayer();
        player.chooseChoice();
        int strike = umpirePitch(computerChoice, player.userChoice.choice);
        if (strike == BallChoice.CHOICE_SIZE) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        } else {
            return false;
        }
    }

    static int umpirePitch(String computerChoice, String userChoice) {
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < computerChoice.length(); i++) {
            if (computerChoice.charAt(i) == userChoice.charAt(i)) {
                strike += 1;
            }
        }

        for (int i = 0; i < userChoice.length(); i++) {
            if (calculateBall(computerChoice, userChoice.charAt(i))) {
                ball += 1;
            }
        }

        ball -= strike;
        callUmpire(strike,ball);
        return strike;
    }

    static boolean calculateBall(String computerChoice, int pitch) {
        boolean ball = false;

        for (int i = 0; i<computerChoice.length(); i++) {
            if (computerChoice.charAt(i) == pitch) {
                ball = true;
            }
        }
        return ball;
    }

    static void callUmpire(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        }else if (strike == 0 && ball != 0) {
            System.out.println(ball+"볼");
        }else if (strike !=0 && ball == 0) {
            System.out.println(strike+"스트라이크");
        }else {
            System.out.println(ball+"볼 "+strike+"스트라이크");
        }
    }
}
