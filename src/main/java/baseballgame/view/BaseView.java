package baseballgame.view;

/**
 * @author KSKIM
 * @version 1.0.0
 * @since 2019-12-03
 */
public class BaseView {
    private static final String MESSAGE_PREFIX = "# ";

    public static void showSystemMessage(String message) {
        System.out.print(MESSAGE_PREFIX + message);
    }

    public static void showSystemMessageWithNewLine(String message) {
        System.out.println(MESSAGE_PREFIX + message);
    }
}
