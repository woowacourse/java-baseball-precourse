package view;

import domain.RandomNumber;
import domain.ValidatorNumber;

import java.io.IOException;

public class Main {
    private static final UserInput userInput = new UserInput();
    private static final ValidatorNumber validator = new ValidatorNumber();
    private static final RandomNumber random = new RandomNumber();

    private static int userNumber = 0;

    public static void main(String[] args) throws IOException {
        while (true) {
            int randomNumber = random.makeNumber();

            do {
                System.out.println("세자리 수를 입력해주세요! 결과가 표시됩니다. ");
                userNumber = userInput.makeNumber();
                System.out.println(
                        validator.compareRandomNumberWithUserInput(randomNumber, userNumber));
            } while (randomNumber != userNumber);
            System.out.println("정답을 맞히셨습니다!");

            if (userInput.endGame())
                break;
        }
    }
}
