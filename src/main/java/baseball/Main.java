package baseball;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Computer computer = new Computer();
        User user = new User();

        boolean gameState = true;

        while (gameState){
            user.readMessage(computer.sendMessage());
            computer.readMessage(user.sendMessage());
        }
    }
}