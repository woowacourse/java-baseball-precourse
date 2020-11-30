package baseball.view;

import baseball.domain.ScoreBoard;
import baseball.domain.value.Result;

public class OutputView {
    public static final String GAME_END_MSG = "개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public static void printResult(ScoreBoard scoreBoard){
        if(scoreBoard.getStrike() == scoreBoard.getNumbersToGuess()){
            System.out.println(scoreBoard.getStrike() + Result.STRIKE.getKorean());
            System.out.println(scoreBoard.getStrike() + GAME_END_MSG);
        }else if(scoreBoard.getBall() != 0 && scoreBoard.getStrike() != 0){
            System.out.println(scoreBoard.getBall() + Result.BALL.getKorean() + " "
                    + scoreBoard.getStrike() + Result.STRIKE.getKorean());
        } else if(scoreBoard.getBall() != 0){
            System.out.println(scoreBoard.getBall() + Result.BALL.getKorean());
        } else if(scoreBoard.getStrike() != 0){
            System.out.println(scoreBoard.getStrike() + Result.STRIKE.getKorean());
        }else{
            System.out.println(Result.NOTHING.getKorean());
        }
    }
}
