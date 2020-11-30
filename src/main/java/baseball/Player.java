package baseball;

import java.util.Scanner;
import interfaces.IPlayer;
import utils.ValidateUtils;

public class Player implements IPlayer {
    private BaseballGameNumber baseballGameNumber;

    public Player() {
        baseballGameNumber = new BaseballGameNumber();
    }

    @Override
    public void inputThreeNumber(Scanner scanner) {
        // TODO Auto-generated method stub
        int[] numbers = new int[BaseballGameNumber.SIZE_OF_ARRAY];
        String input = scanner.next();
        if (ValidateUtils.validateInput(input)) {
            String[] split = input.split("");
            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = Integer.valueOf(split[i]);
            }
            baseballGameNumber.setNumbers(numbers);
        }
    }

    @Override
    public BaseballGameNumber getBaseballGameNumber() {
        // TODO Auto-generated method stub
        return this.baseballGameNumber;
    }

    @Override
    public int inputForRestart(Scanner scanner) {
        // TODO Auto-generated method stub
        int input = scanner.nextInt();
        ValidateUtils.validateInputForRestart(input);
        return input;
    }
}
