package modules;

import java.util.Scanner;

public class InputOutputManager {
    Scanner scanner;
    
    public InputOutputManager(Scanner scanner){
        this.scanner = scanner;
    }

    public int[] askUserInputNumber(){
        System.out.print("숫자를 입력해주세요 : ");
        String inputNumber = scanner.nextLine();
        return parseToIntArray(inputNumber);
    }

    private int[] parseToIntArray(String input){
        // TODO 예외처리

        int[] intArray = new int[input.length()];
        for(int i = 0; i < input.length(); i++){
            intArray[i] = Character.getNumericValue(input.charAt(i));
        }

        return intArray;
    }
}
