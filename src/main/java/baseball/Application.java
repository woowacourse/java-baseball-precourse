package baseball;
import java.util.Scanner;
import utils.RandomUtils;

import static baseball.AnswerCheck.answerCheck;
import static baseball.BaseBallGameController.baseBallGameController;
import static baseball.MakeRandomThreeNumber.makeRandomThreeNumber;
import static baseball.UserInput.errorPrint;
import static baseball.UserInput.userInput;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        int validCountOfNumber = 3;
        int userChoiceRestartOption;
        while(true) {
            int [] computerNumber = makeRandomThreeNumber();
            /*
            테스트용 컴퓨터 숫자 출력 코드
            System.out.println("computerNumber");
            System.out.println(computerNumber[0]);
            System.out.println(computerNumber[1]);
            System.out.println(computerNumber[2]);
            */
            baseBallGameController(computerNumber, scanner, validCountOfNumber);

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            try {
                userChoiceRestartOption = userInput(scanner.nextLine(), 1)[0];
            } catch(IllegalArgumentException e){
                errorPrint();
                break;
            }
            if (userChoiceRestartOption == 1){
                continue;
            }
            else if (userChoiceRestartOption == 2){
                break;
            }
            else{
                errorPrint();
                break;
            }
        }
    }
}