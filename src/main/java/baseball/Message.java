package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Message {
    public static void printMessage(String message){
        System.out.print(message);
    }

    public static String getMessage(){
        return Console.readLine();
    }
}
