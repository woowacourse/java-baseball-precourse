package baseball;

import static baseball.NumberChecker.*;

import java.util.List;

public class AnswerChecker {
    private final Players players;
    private final Result result;

    public AnswerChecker(Players players) {
        this.players = players;
        this.result = new Result();
    }

    public boolean isAnswer() {
        return result.isAnswer();
    }

    public Result calculateResult(Players players){
        User user = players.getUser();
        System.out.println("유저의 숫자들 : " + players.getUser().getNumbers().toString());
        System.out.println("컴퓨터의 숫자들 : " + players.getComputer().getNumbers().toString());
        List<Integer> userNumbers = user.getNumbers();
        for (int userIndex = 0; userIndex < BASEBALL_NUMBERS_SIZE; userIndex++){
            int userNumber = userNumbers.get(userIndex);
            setResult(userIndex, userNumber);
        }
        return result;
    }

    private void setResult(int userIndex, int userNumber) {
        calculateStrikeOrBall(userIndex, userNumber);
    }

    private void calculateStrikeOrBall(int userIndex, int userNumber) {
        Computer computer = players.getComputer();
        List<Integer> computerNumbers = computer.getNumbers();
        if (computerNumbers.get(userIndex) == userNumber) {
            result.strike();
            return;
        }
        for (int comIndex = 0; comIndex < computerNumbers.size(); comIndex++) {
            if (computerNumbers.get(comIndex) == userNumber && comIndex != userIndex) {
                result.ball();
            }
        }
    }
}
