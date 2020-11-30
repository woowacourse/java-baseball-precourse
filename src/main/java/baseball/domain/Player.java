package baseball.domain;

import baseball.validator.PlayerNumberFormatValidator;

import java.util.Scanner;

public class Player {
    private Scanner scanner;
    private String number;

    public Player(Scanner scanner){
        this.scanner = scanner;
    }

    public void getInputValue(){
        number = scanner.nextLine();
        if(!PlayerNumberFormatValidator.validate(number)){
            throw new IllegalArgumentException();
        }
    }

    public String getNumber(){
        return this.number;
    }
}
