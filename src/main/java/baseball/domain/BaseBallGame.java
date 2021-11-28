package baseball.domain;

import java.util.ArrayList;
import java.util.HashSet;

import camp.nextstep.edu.missionutils.Console;

public class BaseBallGame {
    public final String INPUT_MESSAGE = "숫자를 입력해 주세요: ";
    public final int INPUT_SIZE_LIMIT = 3;
    private String input;

    public void validate(String input){
        HashSet<Character> storeNumber = new HashSet<>();

        if(input.length() != INPUT_SIZE_LIMIT){
            throw new IllegalArgumentException();
        }

        for(int i = 0; i < input.length(); i++) {
            if (storeNumber.contains(input.charAt(i))){
                throw new IllegalArgumentException();
            }
            storeNumber.add(input.charAt(i));

            if (!Character.isDigit(input.charAt(i))){
                throw new IllegalArgumentException();
            }

            if (input.charAt(i) == '0'){
                throw new IllegalArgumentException();
            }
        }
    }

    public void start(ArrayList<String> randomNumber){
        System.out.print(INPUT_MESSAGE);
        input = Console.readLine();

        validate(input);
    }
}

