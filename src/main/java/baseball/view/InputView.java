package baseball.view;

import java.util.Scanner;

/**
 * 입력을 담당하는 클래스
 *
 * @author 조연우
 * @version 1.0 2020년 11월 25일
 */
public class InputView {
    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String receiveInputNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        return this.scanner.nextLine();
    }

    public String receiveRestartFlag() {
        return this.scanner.nextLine();
    }
}
