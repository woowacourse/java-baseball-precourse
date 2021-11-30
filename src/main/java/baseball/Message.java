package baseball;

import camp.nextstep.edu.missionutils.Console;

/*
 * 입출력을 담당합니다.
 */
public class Message {
    public static void printMessage(String message){
        System.out.print(message);
    }

    public static String getMessage(){
        return Console.readLine();
    }
}
