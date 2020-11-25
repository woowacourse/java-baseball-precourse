package baseball;

import java.util.Scanner;

public class BaseBallGame {

    private final UserInput userInput;

    public BaseBallGame(Scanner scanner) {
        this.userInput = new UserInput(scanner);
    }

    public void start() {
        while (true) {
            int userInput = this.userInput.getUserInput();
            System.out.println("사용자가 입력한 숫자 : " + userInput);
            if (userInput == 999) {
                break;
            }
        }
        System.out.println("사용자가 999를 입력하여 프로그램을 종료합니다.");
    }

}
