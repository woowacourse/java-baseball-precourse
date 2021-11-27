package baseball;

public class Application {
    public static void main(String[] args) {
        //TODO: 숫자 야구 게임 구현
		final Player humanPlayer = new HumanPlayer();
		final Player computerPlayer = new ComputerPlayer(new RandomNumber());
		BaseballGame baseballGame = new BaseballGame(humanPlayer, computerPlayer);
		baseballGame.StartBaseballGame();
    }
}
