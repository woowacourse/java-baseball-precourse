package baseball;

public class Baseball {
    private ConsoleView view;
    private final int DIGIT = 3;
    private final String COLLECT_AND_GAME_END_MESSAGE = "%d개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public Baseball(ConsoleView consoleView) {
        this.view = consoleView;
    }

    public void start() {
        String randomNumber = NumberGenerator.randomNumberGenerate(DIGIT);
        String userInput = this.view.requestNumber();
        GameRule gameRule = GameRule.compare(randomNumber, userInput);
        view.println(gameRule.printResult());

        while (!gameRule.isCollect()) {
            userInput = this.view.requestNumber();
            gameRule.changeUserInput(userInput);
            view.println(gameRule.printResult());
        }

        view.println(String.format(COLLECT_AND_GAME_END_MESSAGE, DIGIT));
    }
}
