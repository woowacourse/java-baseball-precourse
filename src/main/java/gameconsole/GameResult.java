package gameconsole;

import views.Output;

import java.util.ArrayList;

public class GameResult {
    private int strikeNumber = 0;
    private int ballNumber = 0;

    public static GameResult createGameResult() {
        return new GameResult();
    }

    boolean showResult(ArrayList<Integer> answerList, ArrayList<Integer> userList) {
        calculateResult(answerList, userList);
        Output.printHint(strikeNumber, ballNumber);

        return strikeNumber == 3;
    }

    private void calculateResult(ArrayList<Integer> answerList, ArrayList<Integer> userList) {
        for (Integer number : userList) {
            if (answerList.contains(number) && userList.indexOf(number) == answerList.indexOf(number)) {
                strikeNumber += 1;
            } else if (answerList.contains(number) && userList.indexOf(number) != answerList.indexOf(number)) {
                ballNumber += 1;
            }
        }
    }
}
