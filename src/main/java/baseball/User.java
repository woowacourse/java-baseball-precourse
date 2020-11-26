package baseball;

import java.util.Scanner;

public class User {

    private Scanner sc = new Scanner(System.in);

    private InputValidator inputValidator;

    public User(){
        inputValidator=new InputValidator();
    }

    public String inputNumber(){
        return inputValidator.isValidString(InputView.getUserString());
    }
}
