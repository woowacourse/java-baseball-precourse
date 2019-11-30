package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.IllegalFormatConversionException;

public class UserInput {
    private static final int DEFAULT_INT_ZERO = 0;
    private static final int END_GAME = 2;
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final int START_GAME = 1;

    public boolean endGame() throws IOException {
        System.out.println("게임을 시작하려면 1번 종료하려면 2번을 입력해주세요 ! ");
        int userInput = makeNumberAndCheckStringError();

        while (true) {
            if (userInput != START_GAME && userInput != END_GAME) {
                System.out.println("1또는 2의 수를 입력해주세요~(1번 : 시작, 2번 : 종료)");
                userInput = makeNumberAndCheckStringError();
            } else
                break;
        }

        if (userInput == END_GAME)
            return true;
        return false;
    }

    public int makeNumber() throws IOException {
        System.out.println("3자리 숫자를 입력해주세요! 입력 후 엔터를 누르시면 결과를 보여드립니다.");
        int userInput = makeNumberAndCheckStringError();

        while (String.valueOf(userInput).length() != 3) {
            System.out.println("세 자리 수로 입력해주세요! 다른 자리수는 안돼요~");
            userInput = makeNumberAndCheckStringError();
        }
        return userInput;
    }

    private int makeNumberAndCheckStringError() throws IOException {
        int userInput = DEFAULT_INT_ZERO;

        while (userInput > 0) {
            try {
                userInput = Integer.parseInt(br.readLine().trim());
            } catch (IllegalFormatConversionException e) {
                System.out.println("문자는 입력이 되지 않아요. 숫자로 입력해주세요");
            }
        }
        return userInput;
    }
}
