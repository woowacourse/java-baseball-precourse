package baseball;

import baseball.number.ComputerNumber;
import baseball.number.NumberService;
import baseball.number.UserNumber;
import baseball.result.GameResult;
import baseball.result.GameResultService;
import baseball.view.BaseballView;

public class PlayBall {

    ComputerNumber computerNumber;
    NumberService numberService;
    UserNumber userNumber;
    GameResult gameResult;
    GameResultService gameResultService;

    //게임 진행을 위한 초기화
    public void startGame() {
        computerNumber = new ComputerNumber();
        numberService = new NumberService();

        createComputerNumber();
    }

    //컴퓨터 숫자 생성
    private void createComputerNumber() {
        numberService.createComputerNumber(computerNumber);

        getUserInput();
    }

    //사용자 숫자 입력 받기
    private void getUserInput() {
        userNumber = new UserNumber();
        String userInput = BaseballView.getUserInput();

        checkUserInput(userInput);
    }

    //유효한 입력인지 확인
    private void checkUserInput(String userInput) {
        try {
            numberService.checkUserInput(userInput, userNumber);

            getGameResult();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }

    //입력에 대한 결과 저장
    private void getGameResult() {
        gameResult = new GameResult();
        gameResultService = new GameResultService(gameResult);

        gameResultService.countStrike(computerNumber, userNumber);
        gameResultService.countBall(computerNumber, userNumber);

        createResultMessage();
    }

    //결과에 따른 출력 메세지 생성
    private void createResultMessage() {
        gameResultService.createResultMessage();

        printResult();
    }

    //결과 메세지 출력
    private void printResult() {
        BaseballView.printResultMessage(gameResult);

        checkGameOver();
    }

    //3스트라이크인지 확인
    private void checkGameOver() {
        if (gameResult.getStrikeCount() == 3) {
            BaseballView.printGameOverView();

            getRepeatInput();
            return;
        }

        //3스트라이크가 아니면 재입력 받기
        getUserInput();
    }

    //재시작 유무 입력 받기
    private void getRepeatInput() {
        String userRestartInput = BaseballView.getUserRestartInput();

        try {
            checkUserRestartInput(userRestartInput);

            isRestart(userRestartInput);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }

    }

    //재시작 입력이 정상 입력인지 확인
    private void checkUserRestartInput(String userRestartInput) throws IllegalArgumentException {
        if (userRestartInput.equals("1")
                || userRestartInput.equals("2")) {
            return;
        }
        throw new IllegalArgumentException();
    }

    //재시작 결정
    private void isRestart(String userRepeatInput) {
        if (userRepeatInput.equals("1")) {
            startGame();
        }
    }
}
