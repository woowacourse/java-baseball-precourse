package baseball;

import java.util.Scanner;

public class InputNumber {
    public static final String WARNING_MESSAGE = "1에서 9까지 서로 다른 임의의 수 3개를 입력해 주세요";
    public static String getInput(Scanner scanner){
        String inputNumber = scanner.next();
        if(validateInput(inputNumber)){
            return inputNumber;
        }else{
            return WARNING_MESSAGE;
        }
    }
}
