package baseballgame;

/**
 * @author KSKIM
 * @version 1.0.0
 * @since 2019-11-28
 */
public enum MenuType {

    RESTART("1"), EXIT("2");

    private static final String EXCEPTION_NOT_MENU = "# 잘못된 메뉴를 선택하셨습니다.";

    private final String code;

    MenuType(String code) {
        this.code = code;
    }

    public static MenuType of(String code) {
        for (MenuType menuValue: MenuType.values()) {
            if (menuValue.code.equals(code)) {
                return menuValue;
            }
        }
        throw new IllegalArgumentException(EXCEPTION_NOT_MENU);
    }
}
