package baseball;

import camp.nextstep.edu.missionutils.Console;
import constant.SystemMessage;

import java.util.List;

public class Player {

    public static List<Integer> getUserInput(){
        System.out.println(SystemMessage.INPUT_QUESTION);
        String inputString = Console.readLine();
        Validation.inputCheck(inputString);
        List<Integer> inputList = Utils.parseStringToList(inputString);
        return inputList;
    };

}
