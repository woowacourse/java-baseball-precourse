package baseball;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        Computer computer = new Computer();
        ArrayList<Integer> computerNumber = computer.createComputerNumber();
        System.out.println(computerNumber);

        User user = new User();
        ArrayList<Integer> userNumber = user.inputUserNumber();
        System.out.println(userNumber);

    }
}
