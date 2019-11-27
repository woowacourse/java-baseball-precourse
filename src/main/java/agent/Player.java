package agent;

import java.util.Scanner;

public class Player {
    private String userInput;
    Scanner scanner;
    public Player() {
        scanner = new Scanner(System.in);
    }

    public String getUserInput() {
        return userInput;
    }

    public void setUserInput() {
        System.out.print("숫자를 입력해주세요: ");
        userInput = scanner.next();
    }
}
