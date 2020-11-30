package baseball;

import java.util.Scanner;

/**
 * main문을 실행하는 Application
 * 게임을 실행하고, 게임이 종료되면 유저의 입력을 받아 게임을 다시 실행할지 결정한다.
 * @author 성시형
 * @version 1.0
 */
public class Application {
    private ConsoleView view;

    /**
     * View 클래스를 인자로 받는 생성자
     * @param consoleView 콘솔 뷰
     * 콘솔에서 입력과 출력을 하는 클래스
     */
    Application(ConsoleView consoleView) {
        this.view = consoleView;
    }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        Application app = new Application(new ConsoleView(scanner));
        app.run();
    }

    private void run() {
        Baseball baseball = new Baseball(this.view);
        do {
            baseball.start();
        } while (this.view.askWantContinue());
    }

}
