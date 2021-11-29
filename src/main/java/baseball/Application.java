package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    static String gameStatus;

    public static void main(String[] args) {
        gameStatus = "1";
        while (gameStatus.equals("1")) {
            input3Digits();
        }
    }

    static Referee referee = new Referee();
    static ThreeDifferentDigits answer = new ThreeDifferentDigits();

    static void input3Digits(){
        System.out.print("숫자를 입력해 주세요 : ");

        String input = Console.readLine();

        CheckException.is3DigitValid(input);

        referee.judge(answer.getDigits(), input.split(""));
    }

    static void continueGame(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        CheckException.isRightCommand(input);
        gameStatus = "2";
        if (input.equals("1")){
            gameStatus = "1";
            answer = new ThreeDifferentDigits();
        }
    }
}