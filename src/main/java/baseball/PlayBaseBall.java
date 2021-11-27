package baseball;

public class PlayBaseBall {
    private Computer computer;
    private User user;
    private AnswerChecker answerChecker;

    public PlayBaseBall() {
        this.user = new User();
    }

    public void start() {
        do {
            this.computer = new Computer();
            computer.pickUniqueThreeNumbersInRange();
            this.answerChecker = new AnswerChecker(computer.convertToList());
            answerChecker.setVisit();
            play();
            computer.clear();
        } while (user.isContinue());
    }

    public void play() {
        do {
            user.inputNumbers();
            answerChecker.clear();
            answerChecker.calculateBallOrStrike(user.convertStringToList());
            HintMaker.makePrintMessage(answerChecker.getStrikeCount(), answerChecker.getBallCount());
        } while (!HintMaker.isAnswer(answerChecker.getStrikeCount()));
    }
}
