package baseball;

import baseball.number.ComputerNumber;
import baseball.number.NumberService;
import baseball.number.UserNumber;
import baseball.view.BaseballView;

public class PlayBall {
    ComputerNumber computerNumber;
    NumberService numberService;
    UserNumber userNumber;

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
        } catch (IllegalArgumentException e){
            return;
        }
    }
}
