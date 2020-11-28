package numbers;

import utils.StringHandler;
import utils.UserInputValidator;

import java.util.ArrayList;
import java.util.Scanner;

public class UserSelectNumber {

    private ArrayList<Integer> userSelectNumber = new ArrayList<>();

    public static UserSelectNumber createUserSelectNumber(){
        return new UserSelectNumber();
    }

    public void setUserSelectNumber() {
        String userInput = receiveUserString();
        StringHandler stringHandler = StringHandler.createStringHandler();
        this.userSelectNumber = stringHandler.stringToArrayList(userInput);
    }

    public String receiveUserString() {
        Scanner scanner = new Scanner(System.in);
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
}
