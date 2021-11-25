package baseball;

public class PlayBaseBall {
    private Computer computer;
    private User user;
    private AnswerChecker answerChecker;
    private HintMaker hintMaker;

    public PlayBaseBall() {
        this.user = new User();
    }

    public void start() {
        do {
            this.computer = new Computer();
            play();
        } while (user.isContinue());
    }

    public void play() {
        do {
            user.inputNumbers();
            answerChecker = new AnswerChecker(computer.convertToList());
            answerChecker.calculateBallOrStrike(user.convertStringToList());
            hintMaker = new HintMaker(answerChecker.getStrikeCount(), answerChecker.getBallCount());
            hintMaker.makePrintMessage();
        } while (!hintMaker.isAnswer());
    }
}
