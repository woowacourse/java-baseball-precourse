package domain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserInput {
    private static final int END_GAME = 2;
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public boolean endGame() throws IOException {
        System.out.println("게임을 시작하려면 1번 종료하려면 2번을 입력해주세요 ! ");
        int userInput = Integer.parseInt(br.readLine().trim());
        if (userInput == END_GAME)
            return true;
        return false;
    }

    public int makeNumber() throws IOException {
        System.out.println("3자리 숫자를 입력해주세요! 입력 후 엔터를 누르시면 결과를 보여드립니다.");
        int userInput = Integer.parseInt(br.readLine().trim());
        return userInput;
    }
}
