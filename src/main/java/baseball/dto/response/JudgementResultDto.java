package baseball.dto.response;

public class JudgementResultDto {

    private final boolean isCorrectAnswer;
    private final String resultMessage;

    public JudgementResultDto(boolean isCorrectAnswer, String resultMessage) {
        this.resultMessage = resultMessage;
        this.isCorrectAnswer = isCorrectAnswer;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public boolean isCorrectAnswer() {
        return isCorrectAnswer;
    }
}
