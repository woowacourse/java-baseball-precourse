package baseball;

import java.util.Scanner;
import interfaces.IPlayer;
import utils.ValidateUtils;

public class Player implements IPlayer {
    BaseballGameNumber baseballGameNumber;

    public Player() {
        baseballGameNumber = new BaseballGameNumber();
    }

    @Override
    public void inputThreeNumber(Scanner scanner) {
        // TODO Auto-generated method stub
        int[] numbers = new int[BaseballGameNumber.SIZE_OF_ARRAY];
        int input = scanner.nextInt();
        if (ValidateUtils.validateInput(input)) {
            String[] split = String.valueOf(input).split("");
            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = Integer.valueOf(split[i]);
            }
            baseballGameNumber.setNumbers(numbers);
        }
    }


}
