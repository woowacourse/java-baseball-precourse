public class Main {
    public static void main(String[] args) {
        boolean play = true;

        while (play) {
            Baseball baseball = new Baseball();

            boolean result = false;

            while (!result) {
                baseball.getUserInput();

                result = baseball.checkResult();
            }

            play = baseball.choose();
        }
    }
}
