package baseball;

import java.util.Scanner;

public class Game {
    public void start(Scanner scanner) {
        Integer number;

        System.out.print("서로 다른 3자리 숫자를 입력해주세요 : ");
        if (scanner.hasNextInt()) {
            number = scanner.nextInt();
            if (validate(number)) {
                System.out.println("입력숫자: " + number);
            }
        }
        else if (!scanner.hasNextInt()){
            scanner.next();
        }
    }

    public boolean validate(int number) {
        int first = number / 100;
        int second = (number % 100) / 10;
        int third = number % 10;

        if (number >= 1000 || number < 100) {
            return false;
        }
        else if (first == second || first == third || second == third) {
            return false;
        }
        return true;
    }
}
