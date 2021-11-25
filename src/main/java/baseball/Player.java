package baseball;

import utils.Validation;

import java.util.stream.Stream;

import static camp.nextstep.edu.missionutils.Console.readLine;


public class Player {
    public int[] getInput(){
        String input = readLine();

        Validation.validate(input);

        int[] inputNum = Stream.of(input.split(""))
                .mapToInt(Integer::parseInt)
                .toArray();

        return inputNum;
    }
}
