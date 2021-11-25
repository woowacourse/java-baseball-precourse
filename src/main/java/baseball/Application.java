package baseball;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        Computer computer = new Computer();
        ArrayList<Integer> computerNumberList = computer.createComputerNumber();
        System.out.println(computerNumberList);

        User user = new User();
        ArrayList<Integer> userNumberList = user.inputUserNumber();
        System.out.println(userNumberList);

        GameReferee gameReferee = new GameReferee();
        gameReferee.decideResult(computerNumberList, userNumberList);
    }
}
