package baseball;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class GamePlayer {
    private static final char FIRST_BOUNDARY_VALUE = '1';
    private static final char LAST_BOUNDARY_VALUE = '9';
    private static final int INPUT_NUMBER_COUNT = 3;
    private static final String REINPUT = "다시 입력해주세요";
    private static final int RESTART = 1;
    private static final int END = 2;

    private Scanner scanner;

    public GamePlayer(Scanner scanner){
        this.scanner = scanner;
    }

    public String generateNumbersOfPlayerEntered()
                                            throws IllegalArgumentException{
        String generatedNumbers = scanner.next();
        if(generatedNumbers.length() != INPUT_NUMBER_COUNT){
            throw new IllegalArgumentException(REINPUT);
        }

        if(isNotAllNumbers(generatedNumbers)){
            throw new IllegalArgumentException(REINPUT);
        }

        if(haveDuplicateNumbers(generatedNumbers)){
            throw new IllegalArgumentException(REINPUT);
        }

        return generatedNumbers;
    }

    private boolean isNotAllNumbers(String generatedNumbers){
        for(int i=0; i<generatedNumbers.length(); i++){
            if(generatedNumbers.charAt(i) < FIRST_BOUNDARY_VALUE
                    || generatedNumbers.charAt(i) > LAST_BOUNDARY_VALUE){
               return true;
            }
        }
        return false;
    }

    private boolean haveDuplicateNumbers(String generatedNumbers){
        Set<Character> numbers = new HashSet<>();
        for(int i=0; i<generatedNumbers.length(); i++){
            numbers.add(generatedNumbers.charAt(i));
        }
        return numbers.size() != INPUT_NUMBER_COUNT;
    }

    public int selectRestartOrEnd() {
        String inputNumber = scanner.next();

        while (isInvalidInputNumber(inputNumber)) {
            System.out.println(REINPUT);
            inputNumber = scanner.next();
        }

        return inputNumber.charAt(0) - '0';
    }

    private boolean isInvalidInputNumber(String inputNumber){
        int singleDigitInputNumber = inputNumber.charAt(0) - '0';

        return inputNumber.length() != 1
                || (singleDigitInputNumber != RESTART && singleDigitInputNumber != END);
    }

}
