package baseball.domain;

import baseball.validator.NumberFormatValidator;

import java.util.Scanner;

public class Player {
    private Scanner scanner;
    private String number;

    public Player(Scanner scanner){
        this.scanner = scanner;
    }

    public void getInputValue(){
        number = scanner.nextLine();
        if(!NumberFormatValidator.validate(number)){
            throw new IllegalArgumentException();
        }
    }
}
