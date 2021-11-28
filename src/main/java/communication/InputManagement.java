package communication;

import camp.nextstep.edu.missionutils.Console;

public class InputManagement {
    public void requestUserInput() {
        System.out.println(Text.INPUT_REQUEST);
    }

    private String receiveUserInput() {
        return Console.readLine();
    }

    public String provideUserInput() {
        String usersNumber = receiveUserInput();

        return usersNumber;
    }
}
