package communication;

import camp.nextstep.edu.missionutils.Console;

public class InputManagement {
    private final int ESSENTIAL_NUMBER_LENGTH = 3;
    private final String REGEX_NUMBER = "^[1-9]*$";

    public void requestUserInput() {
        System.out.println(Text.INPUT_REQUEST);
    }

    public void requestUserChoice() {
        System.out.println(Text.RESTART_OR_END);
    }

    private String receiveUserInput() {
        return Console.readLine();
    }

    private boolean isValidUsersNumber(String usersNumber) {

        if (usersNumber.length() != ESSENTIAL_NUMBER_LENGTH) {
            throw new IllegalArgumentException();
        }

        if (usersNumber.matches(REGEX_NUMBER)) {
            throw new IllegalArgumentException();
        }

        for (int i = ESSENTIAL_NUMBER_LENGTH - 1; i >= 0; i--) {

            if (usersNumber.indexOf(usersNumber.charAt(i)) != 1) {
                throw new IllegalArgumentException();
            }

        }

        return true;
    }

    public String provideUserInput() {
        String usersNumber = receiveUserInput();

        if (isValidUsersNumber(usersNumber)) {
            return usersNumber;
        }

        return null;
    }

    public String provideUserChoice() {
        String usersChoice = receiveUserInput();

        return usersChoice;
    }
}
