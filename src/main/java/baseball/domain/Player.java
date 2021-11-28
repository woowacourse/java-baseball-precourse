package baseball.domain;

public class Player {
    private static Player instance = new Player();
    private int[] tryNumber = new int[3];

    private Player() {
    }

    public static Player getInstance() {
        if (instance == null) {
            return new Player();
        }
        return instance;
    }

    public int[] submitTryNumber() {
        return tryNumber;
    }

    public void playerInput(String playerInput) {
        int input = Integer.parseInt(playerInput);
        tryNumber[0] = input / 100;
        tryNumber[1] = (input % 100) / 10;
        tryNumber[2] = input % 10;
    }
}
