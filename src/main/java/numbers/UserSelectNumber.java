package numbers;

import utils.StringHandler;
import utils.UserInputValidator;

import java.util.ArrayList;
import java.util.Scanner;

public class UserSelectNumber {

    private ArrayList<Integer> userSelectNumber;

    public static UserSelectNumber createUserSelectNumber(){
        return new UserSelectNumber();
    }

    public void setUserSelectNumber(Scanner scanner) {
        String userInput = receiveUserString(scanner);
        StringHandler stringHandler = StringHandler.createStringHandler();
        this.userSelectNumber = stringHandler.stringToArrayList(userInput);
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
