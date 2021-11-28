package baseball;

public class Application {
    public static void main(String[] args) {
        //TODO: 숫자 야구 게임 구현
    }

    public void validateLength(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException();
        }
    }
}
