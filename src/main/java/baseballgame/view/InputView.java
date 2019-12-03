package baseballgame.view;

import baseballgame.MenuType;
import baseballgame.Number;

/**
 * @author KSKIM
 * @version 1.0.0
 * @since 2019-11-28
 */
public class InputView {
    private static final String GUIDE_INPUT_NUMBER = "# 서로 다른 세 자리 숫자를 입력하세요.";
    private static final String GUIDE_INPUT_CONTINUE_OR_EXIT = "# 다시 하시려면 1번, 종료 하시려면 2번을 입력하세요.";
    private static final String ERROR_INVALID_INPUT = "# 잘못 입력하셨습니다.";
    private static final java.util.Scanner SCANNER = new java.util.Scanner(System.in);

    public static Number getNumber() {
        try {
            System.out.println(GUIDE_INPUT_NUMBER);
            String input = SCANNER.nextLine();
            return Number.valueOf(input);
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_INVALID_INPUT);
            return getNumber();
        }
    }

    public static MenuType getMenu() {
        try {
            System.out.println(GUIDE_INPUT_CONTINUE_OR_EXIT);
            String input = SCANNER.nextLine();
            return MenuType.of(input);
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_INVALID_INPUT);
            return getMenu();
        }
    }
}
