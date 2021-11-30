package baseball;

import constant.SystemMessage;

import java.util.List;
import java.util.stream.IntStream;

public class Validation {

    public static void inputCheck(String inputString) {
        if(inputString.length()!=SystemMessage.COMPARE_LENGTH){
            throw new IllegalArgumentException(SystemMessage.INPUT_LENGTH_ERROR);
        }
        IntStream
                .range(0,inputString.length())
                .forEach(index -> {
                    if(!Character.isDigit(inputString.charAt(index))){
                        throw new IllegalArgumentException(SystemMessage.INPUT_NUMERIC_ERROR);
                    }
                });
    };


}
