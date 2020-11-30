package baseball;

import static baseball.AnswerCheck.answerCheck;
import static baseball.UserInput.errorPrint;
import static baseball.UserInput.userInput;

import java.util.Scanner;

public class BaseBallGameController {
    public static void baseBallGameController(int[] computerNumber, Scanner scanner, int validCountOfNumber){
        int [] score;
        int [] userNumber;
        while (true) {
            System.out.print("숫자를 입력해 주세요 : ");
            try {
                userNumber = userInput(scanner.nextLine(), validCountOfNumber);
            } catch (IllegalArgumentException e){
                errorPrint();
                continue;
            }
            score = answerCheck(computerNumber, userNumber,
                validCountOfNumber); // {strike, ball}
            if (score[0] == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            } else if (score[0] == 0 && score[1] == 0) {
                System.out.println("낫싱");
            } else if (score[0] == 0) {
                System.out.println(score[1] + "볼");
            } else if (score[1] == 0) {
                System.out.println(score[0] + "스트라이크");
            } else {
                System.out.println(score[1] + " 볼 " + score[0] + "스트라이크");
            }
        }
    }
}
