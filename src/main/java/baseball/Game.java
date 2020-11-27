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
                System.out.print("서로 다른 3자리 숫자를 입력해주세요 : ");
                continue;
            }
            System.out.println("입력값" + guessNumber);
            Validate.compareToAnswer(guessNumber, answer);

            System.out.print("서로 다른 3자리 숫자를 입력해주세요 : ");
        }
    }

}
