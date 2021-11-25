package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

public class User {
    private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String CONTINUE_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String CONTINUE = "1";
    private static final String STOP = "2";
    private static ArrayList<Integer> userNumbers;
    private BoundaryChecker boundaryChecker;
    private static String inputNumbers;

    public User() {
        boundaryChecker = new BoundaryChecker();
        userNumbers = new ArrayList<>();
    }

    public void inputNumbers() {
        clear();
        System.out.print(INPUT_MESSAGE);
        inputNumbers = Console.readLine();
        checkList(inputNumbers);
        userNumbers.addAll(convertStringToList());
    }

    public boolean isContinue() {
        System.out.println(CONTINUE_MESSAGE);
        String userInput = Console.readLine();
        if (userInput.equals(CONTINUE)) {
            return true;
        }
        if (userInput.equals(STOP)) {
            return false;
        }
        throw new IllegalArgumentException();
    }

    public void checkList(String inputNumbers) {
        boundaryChecker.convertInt(inputNumbers);
        boundaryChecker.checkLength(inputNumbers);
        boundaryChecker.checkDuplicate(convertStringToList());
        boundaryChecker.checkRange(Integer.parseInt(inputNumbers));
    }

    public ArrayList<Integer> convertStringToList() {
        String[] inputStr = inputNumbers.split("");
        ArrayList<Integer> numbers = new ArrayList<>();
        for (String i : inputStr)
            numbers.add(Integer.parseInt(i));
        return numbers;
    }

    public void clear() {
        userNumbers.clear();
    }
}
