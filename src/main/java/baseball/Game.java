package baseball;

import java.util.Scanner;

public class Game {
    public Integer answer;

    public void start(Scanner scanner, Integer answer) {
        Integer guess;
        this.answer = answer;

        System.out.print("서로 다른 3자리 숫자를 입력해주세요 : ");
        if (scanner.hasNextInt()) {
            guess = scanner.nextInt();
            if (Validate.validate(guess)) {
                System.out.println("입력숫자: " + guess);
                compareToAnswer(guess, answer);
            }
        }
        else if (!scanner.hasNextInt()){
            scanner.next();
        }
    }

    public void compareToAnswer(Integer guess, Integer answer) {
        Integer strike = 0;
        Integer ball = 0;
        String guessString = Integer.toString(guess);
        String answerString = Integer.toString(answer);


        for (int i = 0; i < 3; i++) {
            int idx = answerString.indexOf(guessString.charAt(i));
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
