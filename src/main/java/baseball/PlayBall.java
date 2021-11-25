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

    //컴퓨터 숫자 생성 후 저장
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
        } catch (IllegalArgumentException e){
            return;
        }
    }

    //게임 실행 후 결과 저장
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

    //3스트라이크인지 확인 후 진행사항 결정
    private void checkGameOver() {
        if (gameResult.getStrikeCount() == 3) {
//            BaseballView.printGameOverView();
//            getRepeatInput();
            return;
        }

        getUserInput();
    }

    private void getRepeatInput() {

    }
}
