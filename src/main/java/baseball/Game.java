package baseball;

import java.util.Scanner;

public class Game {
    public Integer answer;

    public void startGame(Scanner scanner, String answer) {
        String guessNumber;
        System.out.println("정답: " + answer);

        System.out.print("서로 다른 3자리 숫자를 입력해주세요 : ");
        while (scanner.hasNext()) {
            guessNumber = scanner.nextLine();
            if (!Validate.isValidate(guessNumber)){
                System.out.println("입력 오류");
                continue;
            }
            System.out.println("입력값" + guessNumber);
            compareToAnswer(guessNumber, answer);


            System.out.print("서로 다른 3자리 숫자를 입력해주세요 : ");
        }
    }

    public void compareToAnswer(String guess, String answer) {
        Integer strike = 0;
        Integer ball = 0;


        for (int i = 0; i < 3; i++) {
            int idx = answer.indexOf(guess.charAt(i));
            if (idx == i) strike++;
            else if (idx > -1) ball++;
        }
        if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다.");
        } else if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        } else if (strike == 0) {
            System.out.println(ball + "볼 ");
        } else if (ball == 0 ) {
            System.out.println(strike + "스트라이크 ");
        } else if (strike != 0 && ball != 0) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }

    }
}
