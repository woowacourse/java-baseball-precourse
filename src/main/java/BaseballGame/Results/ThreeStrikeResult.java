package BaseballGame.Results;

import BaseballGame.ComparedResult;

public class ThreeStrikeResult implements ComparedResult {
    @Override
    public void printMessage() {
        System.out.println("3 스트라이크");
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    @Override
    public boolean isGameRunning() {
        return false;
    }
}
