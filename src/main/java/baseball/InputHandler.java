package baseball;

import java.util.Scanner;

public class InputHandler {

    private final Scanner scanner;

    public InputHandler(Scanner scanner) {
        this.scanner = scanner;
    }

    private String getValidInput(Request reqType) {
        String input = scanner.next();
        if (reqType == Request.THREENUMS)
            return threeNumValidCheck(input);
        if (reqType == Request.RESTART)
            return restartValidCheck(input);
        return input;
    }

    private String threeNumValidCheck(String input) {
        if (input.length() != 3)
            throw new IllegalArgumentException();
        for (int i = 0; i < 3; i++) {
            if (!Character.isDigit(input.charAt(i))) throw new IllegalArgumentException();
        }
        return input;
    }

    private String restartValidCheck(String input) {
        if (!input.equals("1")  && !input.equals("2"))
            throw new IllegalArgumentException();
        return input;
    }

    /**
     * inputWrapper 로 감싼 이유는?
     * 입력을 받아오는 getValidInput 은 입력이 유효한지만 검사해서 반환한다.
     * 이 동작을 에러 핸들링까지 추가해서, 유효하게 입력할때까지 무한 반복 시키려하는데,
     * 인덴트 제한이 있으므로 Wrapper 로 뽑아낸 것.
     *
     * @param req
     * @return
     */
    public String inputWrapper(Request req) {
        String userInput;
        while (true) {
            try {
                userInput = getValidInput(req);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("잘못된 입력입니다. 다시 입력하세요.");
            }
        }
        return userInput;
    }
}
