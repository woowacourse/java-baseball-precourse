package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class GameExecutor {

    public static final int NUMBER_LENGTH = 3;

    public GameExecutor () {};

    public List<Integer> getUserAnswer() {
        System.out.print("숫자를 입력해주세요 : ");
        String answer = Console.readLine().trim();

        InputValidator.validateLength(answer);
        InputValidator.validateNumbers(answer);

        return convert2NumberList(answer);
    }

    private List<Integer> convert2NumberList(String input) {
        List<Integer> numberList = new ArrayList<>();

        for (int i = 0 ; i < NUMBER_LENGTH ; i++) {
            numberList.add(Character.getNumericValue(input.charAt(i)));
        }
        return numberList;
    }

}