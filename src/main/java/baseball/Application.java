package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        //TODO: 숫자 야구 게임 구현
        Player player = new Player();
        player.guessNumber();

        Computer computer = new Computer();
        computer.makeThreeDigitNumber();

    }
}
