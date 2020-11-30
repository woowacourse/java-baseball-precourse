package interfaces;

import baseball.BaseballGameNumber;

public interface IHint {
    public boolean isCorrectAnswer(BaseballGameNumber playerNumbers,
            BaseballGameNumber computerNumbers);

    public String getHint(BaseballGameNumber playerNumbers, BaseballGameNumber computerNumbers);
}
