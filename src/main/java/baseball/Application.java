package baseball;

import domain.BaseballNumber;
import domain.BaseballNumberCreator;
import utils.StringConverter;
import validator.PositiveIntegerValidator;
import view.InputView;
import view.OutputView;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
    }

    private static BaseballNumber makeUserBaseballNumber(Scanner scanner) {
        String threeDigitNumber = InputView.getThreeDigitNumber(scanner);
        BaseballNumber userBaseballNumber;
        try {
            PositiveIntegerValidator.validatePositiveInteger(threeDigitNumber);
            userBaseballNumber = BaseballNumberCreator.createBaseballNumber(StringConverter.toIntList(threeDigitNumber));
        } catch (IllegalArgumentException e) {
            OutputView.printMessageAndNewLine(e.getMessage());
            userBaseballNumber = makeUserBaseballNumber(scanner);
        }
        return userBaseballNumber;
    }
}
