package baseball;

import java.util.Scanner;

public class Application {
    private ConsoleView view;
    private final int DIGIT = 3;

    Application(ConsoleView ConsoleView) {
        this.view = ConsoleView;
    }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        Application app = new Application(new ConsoleView(scanner));
        app.run();
    }

    private void run() {
        while(true){
            String randomNumber = NumberGenerator.randomNumberGenerate(DIGIT);
            String userInput = this.view.requestNumber();
            GameRule gameRule = GameRule.compare(randomNumber, userInput);
            gameRule.printResult();

            while (!gameRule.isCollect()) {
                userInput = this.view.requestNumber();
                gameRule.changeUserInput(userInput);
                gameRule.printResult();
            }

            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

            if (!this.view.askWantContinue()) {
                break;
            }
        }
    }

}
