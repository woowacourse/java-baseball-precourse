package utils;

import java.util.stream.Stream;

import static camp.nextstep.edu.missionutils.Console.readLine;


public class Input {
    public int[] getInput(){
        String input = readLine();

        if(input.length() != 3){
            throw new IllegalArgumentException();
        }

        if(input.charAt(0) == '0'){
            throw new IllegalArgumentException();
        }

        int[] inputNum = Stream.of(input.split(""))
                .mapToInt(Integer::parseInt)
                .toArray();

        return inputNum;
    }
}
