package baseball;

import java.util.Scanner;

public class ConsoleView {
    private final Scanner scanner;
    public ConsoleView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String requestNumber(){
        println("숫자를 입력해주세요 : ");
        return scanner.nextLine();
    }

    public void println(String message){
        System.out.println(message);
    }
}
