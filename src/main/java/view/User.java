package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author :   김시영
 * @version :   2.0 2019년 12월 2일
 * @apiNote :   게임진행을 위해 사용자 입력 및 입력 에러 처리를 위한 클래스입니다.
 */
public class User {
    private static final int DEFAULT_INT_ZERO = 0;
    private static final int END_GAME = 2;
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final int START_GAME = 1;

    public boolean wantToEndGame() throws IOException {
        System.out.println("게임을 재시작하려면 1번 종료하려면 2번을 입력해주세요 ! ");
        int userInput = makeNumberAndCheckStringError();

        while (true) {
            if (userInput != START_GAME && userInput != END_GAME) {
                System.out.println("1또는 2의 수를 입력해주세요~(1번 : 시작, 2번 : 종료)");
                userInput = makeNumberAndCheckStringError();
            } else {
                break;  /* 게임을 재 시작하고자 하는 경우 */
            }
        }

        if (userInput == END_GAME) {
            return true;
        }
        return false;
    }

    public int makeNumber() throws IOException {
        int userInput = makeNumberAndCheckStringError();

        while (String.valueOf(userInput).length() != 3) {
            System.out.println("세 자리 수로 입력해주세요! 다른 자리수는 안돼요~");
            userInput = makeNumberAndCheckStringError();
        }
        return userInput;
    }

    private int makeNumberAndCheckStringError() throws IOException {
        int userInput = DEFAULT_INT_ZERO;

        while (true) {
            try {
                userInput = Integer.parseInt(br.readLine().trim());
                break;
            } catch (NumberFormatException e) {
                System.out.println("문자는 입력이 되지 않아요. 숫자로 입력해주세요");
            }
        }
        return userInput;
    }
}
