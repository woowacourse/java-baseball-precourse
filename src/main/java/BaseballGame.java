import java.util.List;

class BaseballGame {


    static final int MAX_NUMBER = 9;
    static final int ANSWER_NUMBERS_COUNT = 3;
    static final int PLAYER_CONTINUE = 1;
    static final int PLAYER_QUIT = 2;

    public static void main(String[] args) {
        Player player = new Player();
        Computer computer = new Computer();

        while (player.toBeContinued()) {
            playBaseballGame(player, computer);
        }

        printEndMessage();
    }

    private static void playBaseballGame(Player player, Computer computer) {
        List<Integer> playerInput;

        computer.makeBaseballGameAnswer();

        do {
            playerInput = player.getPlayerInputNumbers();
            computer.printHintMessage(playerInput);
        }
        while (!computer.isNumberCorrect(playerInput));

        switch (player.getPlayerWillingToContinue()) {
            case PLAYER_CONTINUE:
                return;

            case PLAYER_QUIT:
                player.playerQuitGame();
                break;
        }
    }

    private static void printEndMessage() {
        System.out.println("프로그램이 종료됩니다.");
    }
}
