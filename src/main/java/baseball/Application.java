package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("start game");
        boolean isContinue;
        do{
            PlayBall.play(BaseBallUtil.generateThreeRandomDigits());

            System.out.println("end game");
            String input = Console.readLine();

            if(BaseBallUtil.isValidateChoice(input)) isContinue=setIsContinue(input);
            else throw new IllegalArgumentException();

        }while(isContinue);

    }
    private static boolean setIsContinue(String input){
        return input.equals("1");
    }
}
