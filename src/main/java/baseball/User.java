package baseball;

import camp.nextstep.edu.missionutils.Console;

public class User {
    public User() {

    }

    public char[] userInput() throws IllegalArgumentException{
        char[] input = Console.readLine().toCharArray();
        if (input.length != 3 || input[0] == input[1] || input[1] == input[2] || input[2] == input[0]||
                input[0] == '0' || input[1] == '0' || input[2] == '0') {
            throw new IllegalArgumentException();
        }
        return input;
    }
}
