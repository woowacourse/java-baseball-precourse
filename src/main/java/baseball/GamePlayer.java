package baseball;

import java.util.Scanner;

public class GamePlayer {
    BallChoice userChoice = new BallChoice();

    public void chooseChoice() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("숫자를 입력해주세요 : ");
        userChoice.choice = scanner.nextLine();

        while(ExceptionChecker.checkChoiceException(userChoice.choice)){
            System.out.print("숫자를 입력해주세요 : ");
            userChoice.choice = scanner.nextLine();
        }
    }
}
