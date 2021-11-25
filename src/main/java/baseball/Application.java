package baseball;

public class Application {
    public static void main(String[] args) {
        //TODO: 숫자 야구 게임 구현
        Computer computer = new Computer();

        while (true) {
            computer.initNumber();
            BaseballGame game = new BaseballGame(computer.getNumber(), "");
            game.play();
            if (!game.isRestart()) {
                break;
            }
        }
    }
}
