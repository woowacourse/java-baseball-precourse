package baseball;

import java.util.Scanner;

public class GameController {
    public static final String END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final String END_CONDITION = "3스트라이크";

    public static int playGame(Scanner scanner) {
        //임의의 수를 생성한다
        String randomNumber = RandomNumber.generateNumbers(Application.NUMBER_LENGTH);
        String inputNumber = "";
        int restartGame = 0;

        while (!randomNumber.equals(inputNumber)) {
            //유저에게 숫자를 입력받는다
            inputNumber = InputNumber.getInput(scanner);
            //입력값의 범위를 벗어나서 경고 메세지를 받은 경우
            if (inputNumber.length() != Application.NUMBER_LENGTH) {
                System.out.println(inputNumber);
                continue;
            }
            //심판에게 판단을 받는다
            String result = Referee.judgeNumber(randomNumber, inputNumber);
            if (result.equals(END_CONDITION)) {
                System.out.println(END_MESSAGE);
                restartGame = RestartNumber.askRestart(scanner);
                break;
            } else {
                System.out.println(result);
            }
        }
        return restartGame;
    }
}