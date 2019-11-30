package view;

import domain.Random;
import domain.ValidatorNumber;

import java.io.IOException;

public class Main {
    private static final UserInput userInput = new UserInput();
    private static final ValidatorNumber validator = new ValidatorNumber();
    private static final Random random = new Random();

    private static int userNumber;

    public static void main(String[] args) throws IOException {
        System.out.println("hello world");
        while (true){
            System.out.println("hello world2");
            int randomNumber = random.makeNumber();
            System.out.println("hello world 3");
            do {
                System.out.println("3자리 수를 아래에 입력해주세요 ! 결과가 나옵니다.");
                userNumber = userInput.makeNumber();
                System.out.println(
                        validator.randomNumberCompareToUserInput(randomNumber, userNumber));
            }while(randomNumber!=userNumber);
            System.out.println("정답을 맞히셨습니다! ");
            if(userInput.endGame())
                break;
        }
    }
}
