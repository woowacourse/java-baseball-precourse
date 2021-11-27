package baseball;

import utils.Validation;

import java.util.stream.Stream;

import static camp.nextstep.edu.missionutils.Console.readLine;


public class Player {
    public int[] getInput() {
        System.out.println("숫자를 입력해주세요 : ");
        String input = readLine();

        Validation.validate(input);

        int[] inputNum = Stream.of(input.split(""))
                .mapToInt(Integer::parseInt)
                .toArray();

        return inputNum;
    }

    public int getQuitOrNewGameInput() {
        String input = readLine();
        return Integer.parseInt(input);
    }
}
