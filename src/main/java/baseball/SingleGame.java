package baseball;

import java.util.Scanner;

public class SingleGame {

    public static void play(Scanner scanner) {
        /* gaming 변수가 false가 될 때 까지 실행한다 */
        int targetNumber = TargetNumberGenerator.makeTargetNumber();
        String strikeAndBallResult = "";
        while (!strikeAndBallResult.equals("3스트라이크")){
            /* strikeAndBallResult가 3스트라이크가 될 때 까지 실행한다 */
            String userInput=getUserInput(scanner);
            /* userInput이 유효한 인풋인지 확인한 후, 유효하다면 userInputNumber에 3자리 정수를 반환한다 */
            int userInputNumber= InputException.checkUserInput(userInput);
            /* targetNumber, userInputNumber를 비교하여 스트라이크/볼 결과를 도출한 후 출력 */
            strikeAndBallResult=BallCount.checkStrikeAndBall(targetNumber,userInputNumber);
        }
    }

    public static String getUserInput(Scanner scanner) {
        System.out.print("숫자를 입력해주세요 : ");
        String userInput = scanner.nextLine();
        return userInput;
    }


}


