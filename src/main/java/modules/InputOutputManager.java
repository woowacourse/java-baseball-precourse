package modules;

import java.util.Scanner;

public class InputOutputManager {
    static final int NUMBER_SIZE = 3;
    static final String REQUEST_INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    static final String WRONG_VALUE_MESSAGE = "잘못된 값입니다.";

    Scanner scanner;
    
    public InputOutputManager(Scanner scanner){
        this.scanner = scanner;
    }

    public int[] askUserInputNumber(){
        System.out.print(REQUEST_INPUT_MESSAGE);
        String inputNumber = scanner.nextLine();
        try{
            return parseToIntArray(inputNumber);
        } catch(Exception e){
            System.out.println(WRONG_VALUE_MESSAGE);
            return askUserInputNumber();
        }
    }

    private int[] parseToIntArray(String input){
        if(!checkForParsable(input) || !checkForLengthFit(input)){
            throw new IllegalArgumentException();
        }

        int[] intArray = new int[input.length()];
        for(int i = 0; i < input.length(); i++){
            intArray[i] = Character.getNumericValue(input.charAt(i));
        }

        return intArray;
    }

    private boolean checkForParsable(String input){
        try{
            Integer.parseInt(input);
            return true;
        } catch(Exception e){
            return false;
        }
    }

    private boolean checkForLengthFit(String input){
        if(input.length() == NUMBER_SIZE){
            return true;            
        }
        return false;
    }
}
