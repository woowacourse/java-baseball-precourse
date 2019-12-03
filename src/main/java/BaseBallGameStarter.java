/*
 * 클래스 이름 : BaseBallGameStarter
 *
 * 버전 정보 : 1.0
 *
 * 날짜 : 2019.12.3
 *
 * 저작권 주의 : https://github.com/takhyeongmin
 */

import domain.ScoreBoard;
import utils.ConvertUtil;
import utils.InputUtil;
import utils.OutputUtil;
import utils.ScoreBoardUtil;

public class BaseBallGameStarter {

    private final int REPLAY_YES = 1;
    private final int REPLAY_NO = 2;
    private static InputUtil inputUtil;
    private static OutputUtil outputUtil;
    private static ConvertUtil convertUtil;
    private static ScoreBoardUtil scoreBoardUtil;
    private static Refree refree;

    void startBaseBallGame() {
        Computer computer = new Computer();
        ScoreBoard answerScoreBoard = computer.getScoreBoard();

        initSettings();
        runBaseBallGame(answerScoreBoard);
        restartBaseBallGame();
    }

    private void runBaseBallGame(ScoreBoard answerScoreBoard) {
        while (true) {
            ScoreBoard userScoreBoard = getUserInput();
            checkUserInputBalid(userScoreBoard);

            if (refree.startCountScore(answerScoreBoard, userScoreBoard)) {
                break;
            }
        }
    }

    private void restartBaseBallGame() {
        printRelayQuestion();

        int replayFlag = inputUtil.inputInteger();

        if (replayFlag == REPLAY_YES) {
            startBaseBallGame();
            return;
        }
        if (replayFlag == REPLAY_NO) {
            return;
        }

        throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.");
    }

    private ScoreBoard getUserInput() {
        int userInput = inputUtil.inputInteger();

        outputUtil.printRequireUserScoreBoard();
        return convertUtil.convertScoreBoard(userInput);
    }

    private void checkUserInputBalid(ScoreBoard userScoreBoard) {
        if (scoreBoardUtil.checkValid(userScoreBoard)) {
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.");
        }
    }

    private void initSettings() {
        inputUtil = new InputUtil();
        outputUtil = new OutputUtil();
        convertUtil = new ConvertUtil();
        scoreBoardUtil = new ScoreBoardUtil();
        refree = new Refree();
    }

    private void printRelayQuestion() {
        outputUtil.printRelayQuestion();
    }
}
