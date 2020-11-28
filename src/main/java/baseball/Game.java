package baseball;

import java.util.Scanner;

public class Game {
    public Integer answer;

    public void startGame(Scanner scanner) {
        String answer = RandomAnswer.randomAnswer();
        String guessNumber;

        System.out.print("서로 다른 3자리 숫자를 입력해주세요 : ");
        while (scanner.hasNext()) {
            guessNumber = scanner.nextLine();
            if (!Validate.isValidate(guessNumber)){
                System.out.println("입력 오류");
                System.out.print("서로 다른 3자리 숫자를 입력해주세요 : ");
                continue;
            }
            System.out.println("입력값" + guessNumber);
            if (Validate.isAnswer(guessNumber, answer)) {
                if (Replay.doReplay(scanner)) {
                    System.out.print("서로 다른 3자리 숫자를 입력해주세요 : ");
                    answer = RandomAnswer.randomAnswer();
                    continue;
                }
                System.out.println("게임종료");
                break;
            };
            System.out.print("서로 다른 3자리 숫자를 입력해주세요 : ");
        }
    }

}
