package numbers;

import utils.StringHandler;
import utils.UserInputValidator;

import java.util.ArrayList;
import java.util.Scanner;

public class UserSelectNumber {

    private ArrayList<Integer> userSelectNumber;

    public UserSelectNumber(Scanner scanner) {
        String userInput = receiveUserString(scanner);
        StringHandler stringHandler = StringHandler.createStringHandler();
        this.userSelectNumber = stringHandler.stringToArrayList(userInput);
    }

    public static UserSelectNumber createUserSelectNumber(Scanner scanner){
        return new UserSelectNumber(scanner);
    }

    public String receiveUserString(Scanner scanner) {
        String userInput = null;
        try {
            userInput = scanner.nextLine();
            UserInputValidator userInputValidator = UserInputValidator.createUserInputValidator();
            userInputValidator.isValidNumber(userInput);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        return userInput;
    }

    public ArrayList<Integer> getUserSelectNumber() {
        return userSelectNumber;
    }
}
