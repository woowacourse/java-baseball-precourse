package baseball;

import camp.nextstep.edu.missionutils.Console;
import constant.MessageList;

import java.util.ArrayList;

public class User {
    private static ArrayList<Integer> userNumbers;
    private static String inputNumbers;

    public User() {
        userNumbers = new ArrayList<>();
    }

    public void inputNumbers() {
        clear();
        System.out.print(MessageList.INPUT_MESSAGE);
        inputNumbers = Console.readLine();
        checkList(inputNumbers);
        userNumbers.addAll(convertStringToList());
    }

    public boolean isContinue() {
        System.out.println(MessageList.CONTINUE_MESSAGE);
        String userInput = Console.readLine();
        if (userInput.equals(MessageList.CONTINUE)) {
            return true;
        }
        if (userInput.equals(MessageList.STOP)) {
            return false;
        }
        throw new IllegalArgumentException();
    }

    public void checkList(String inputNumbers) {
        BoundaryChecker.convertInt(inputNumbers);
        BoundaryChecker.checkLength(inputNumbers);
        BoundaryChecker.checkDuplicate(convertStringToList());
        BoundaryChecker.checkRange(Integer.parseInt(inputNumbers));
    }

    public ArrayList<Integer> convertStringToList() {
        String[] inputStr = inputNumbers.split(MessageList.NULL_STRING);
        ArrayList<Integer> numbers = new ArrayList<>();
        for (String i : inputStr)
            numbers.add(Integer.parseInt(i));
        return numbers;
    }

    public void clear() {
        userNumbers.clear();
    }
}
