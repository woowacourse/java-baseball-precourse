package baseball.service.ui;

import baseball.domain.Number;

public class Output {
    public void correctAnswer() {
        System.out.println(Number.NUM_LENGTH + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public void showResult(String answer) {
        System.out.println(answer);
    }

    public void inputNumber() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public void askRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
