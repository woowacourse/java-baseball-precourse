package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        //TODO: 숫자 야구 게임 구현

        Computer computer = new Computer();
        Player player = new Player();

        computer.makeThreeDigitNumber();
        int guessNumber = player.guessNumber(); //TODO 맞출때까지 반복해줘야함.
        computer.compareGuessNumberAndAnswer(guessNumber);
    }
}
