package ui;

import game.model.OneSetResult;
import resources.GameMessage;

import java.io.*;
import java.util.Scanner;

/**
 * {@link ui.BaseballGameInterface}를 implements하여 콘솔 환경에서 입출력이 가능하도록 구현한 클래스.
 *
 * @author delf
 * @see ui.BaseballGameInterface
 */
public class ConsoleInterface implements BaseballGameInterface {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public int[] getInputArray() {
        String line = getInputString("숫자를 입력해주세요: ");

        int[] arr = new int[line.length()];
        for (int i = 0; i < line.length(); i++) {
            arr[i] = line.charAt(i) - '0';
        }
        return arr;
    }

    @Override
    public boolean getTrueOrFalse() {
        while (true) {
            String line = getInputString("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");

            if (line.equals(GameMessage.YES.value())) {
                return true;
            }
            if (line.equals(GameMessage.NO.value())) {
                return false;
            }
        }
    }

    @Override
    public void presentResult(OneSetResult oneSetResult) {
        System.out.println(oneSetResult);
        if (oneSetResult.isHit()) {
            System.out.println(GameMessage.CORRECT.value());
        }
    }

    private String getInputString(String instructions) {
        System.out.print(instructions);
        return scanner.nextLine();
    }
}
