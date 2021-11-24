package baseball;

public class Application {
    public static void main(String[] args) {
        try {
            new BaseBallGame();
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
