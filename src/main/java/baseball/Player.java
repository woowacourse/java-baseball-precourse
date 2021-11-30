package baseball;

import camp.nextstep.edu.missionutils.Console;
import constant.SystemMessage;

public class Player {

    public static String getUserInput(){
        System.out.println(SystemMessage.INPUT_QUESTION);
        String inputString = Console.readLine();
        Validation.inputCheck(inputString);
        return inputString;
    };

}
