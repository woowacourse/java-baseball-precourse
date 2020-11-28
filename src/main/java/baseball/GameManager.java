package baseball;

import java.util.Scanner;

public class GameManager {

    private final InputHandler inputHandler;
    private final BaseBallNumber baseBallNumber;

    public GameManager(Scanner scanner) {
        inputHandler = new InputHandler(scanner);
        baseBallNumber = new BaseBallNumber();
    }

    public void gameStart() {
        // 무작위 숫자 생성
        baseBallNumber.resetNumber();

        do {
            // 입력 받기
            System.out.print("숫자를 입력해주세요 : ");
            String input = inputHandler.inputWrapper(Request.THREENUMS);

            // 정답 여부와 볼 스트라이크 계산
            baseBallNumber.calculateMatching(input);

            // 상태에 맞는 결과 출력
            if (baseBallNumber.isCorrectAnswer()) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                baseBallNumber.resetNumber();
            } else
                System.out.println(baseBallNumber.getHint());

            // 종료 여부 결정
        } while (!receiveEndCode());
    }

    public boolean receiveEndCode() {
        if (!baseBallNumber.isCorrectAnswer()) return false;
        String code = inputHandler.inputWrapper(Request.RESTART);
        return !code.equals("1");
    }
}
