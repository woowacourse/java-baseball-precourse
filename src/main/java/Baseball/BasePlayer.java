package Baseball;

import java.security.InvalidParameterException;
import java.util.Scanner;

public class BasePlayer implements Player {

    protected Scanner scanner;

    protected BasePlayer() {
        this.scanner = new Scanner(System.in);
    }

    protected BasePlayer(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public boolean wantToPlayAgain() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        Integer input = scanner.nextInt();
        if (!isValid(input)) {
            throw new InvalidParameterException("입력값이 옳바르지 않습니다.");
        }

        return input.equals(Will.WantToPlay.getValue());
    }

    private boolean isValid(Integer input) {
        return input.equals(1) || input.equals(2);
    }


}
