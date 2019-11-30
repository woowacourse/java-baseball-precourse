package view;

import domain.Computer;
import domain.NumberValidator;

import java.io.IOException;

public class Main {
    private static final User user = new User();
    private static final NumberValidator validator = new NumberValidator();
    private static final Computer computer = new Computer();

    private static int userNumber = 0;

    public static void main(String[] args) throws IOException {
        while (true) {
            int randomNumber = computer.makeRandomNumber();
            do {
                System.out.println("세자리 수를 입력해주세요! 결과가 표시됩니다. ");
                userNumber = user.makeNumber();
                System.out.println(
                        validator.compareRandomNumberWithUserNumber(randomNumber, userNumber));
            } while (randomNumber != userNumber);
            System.out.println("정답을 맞히셨습니다!");

            if (user.wantToEndGame())
                break;
        }
    }
}
