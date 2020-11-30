package baseball;

/**
 * 베이스볼 게임. 랜덤숫자와 유저가 입력한 결과를 비교하여 정답을 맞출 때 까지 반복한다.
 *
 * @author 성시형
 * @version 1.0
 */
public class Baseball {
    private ConsoleView view;
    private final int DIGIT = 3;
    private final String COLLECT_AND_GAME_END_MESSAGE = "%d개의 숫자를 모두 맞히셨습니다! 게임 종료";

    /**
     *  View 클래스를 인자로 받는 생성자 메소드
     *  @param consoleView 콘솔 뷰
     * 콘솔에서 입력과 출력을 하는 클래스
     */
    public Baseball(ConsoleView consoleView) {
        this.view = consoleView;
    }

    /**
     * 베이스볼 게임을 실행한다.
     * 랜덤숫자를 생성하고, 유저의 입력을 받고, 그 둘을 비교하고,
     * 정답이 아니라면 힌트를 출력한다.
     */
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
