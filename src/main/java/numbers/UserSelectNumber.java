package numbers;

import utils.StringHandler;
import utils.UserInputValidator;

import java.util.ArrayList;
import java.util.Scanner;

public class UserSelectNumber {
    private ArrayList<Integer> userSelectNumber;

    public static UserSelectNumber createUserSelectNumber() {
        return new UserSelectNumber();
    }

    public void setUserSelectNumber(Scanner scanner) {
        String userInput = receiveUserString(scanner);

        this.userSelectNumber = StringHandler.stringToArrayList(userInput);
    }

    private String receiveUserString(Scanner scanner) {
        String userInput = scanner.nextLine();

        UserInputValidator.isValidNumber(userInput);
        return userInput;
    }

    public ArrayList<Integer> getUserSelectNumber() {
        return userSelectNumber;
    }
}
