package baseball;


import camp.nextstep.edu.missionutils.Console;

public class Input{
    static String input ="1";

    static void run() {
        while (!input.equals("2")){
            setInput();
            callSelection();
        }
    }

    static void setInput() throws IllegalArgumentException{
        System.out.print("숫자를 입력해 주세요 : ");

        input = Console.readLine();

        if (!(CheckException.isLengthProper(input) && CheckException.isInputDigit(input))) {
            throw new IllegalArgumentException();
        }
    }

    static void callSelection(){
        if (input.equals("1")){
            new ThreeDifferentDigits();
        } else if (input.length() == 3){
            Check.run();
        }
    }
}