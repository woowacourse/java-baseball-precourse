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

    public void printScore(int strikeCount, int ballCount) {
        String result = "";

        if (ballCount != 0) {
            result = result.concat(ballCount+"볼 ");
        }
        if (strikeCount != 0) {
            result = result.concat(strikeCount +"스트라이크");
        }
        System.out.println(result);
    }

    public void printNothing() {
        System.out.println("낫싱");
    }

    public void printCorrect() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public int getUserSelection() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String selection = Console.readLine().trim();
        InputValidator.validateSelection(selection);
        return Integer.parseInt(selection);
    }

}