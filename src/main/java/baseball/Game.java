package baseball;

import java.util.List;

// 숫자야구의 전반적인 운영을 담당하는 클래스
public class Game {

    Answer answer = new Answer();
    GameReply gameReply = new GameReply();
    Result result = new Result();

    public List<Integer> getAnswer() {
        return answer.getAnswer();
    }

    public void setNewGame() {
        this.answer.makeAnswer();
    }

    public void start() {
        gameReply.askReply();
        result.matchAnswer(this.getAnswer(), gameReply.getGameReply());
        result.printResult();
    }

    public boolean afterGame() {
        return result.getStrike()!=3;
    }
}
