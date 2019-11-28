class BaseballGame {
    static final int MAX_NUMBER = 9;
    static final int ANSWER_NUMBERS_COUNT = 3;

    public static void main(String[] args) {
        Player player = new Player();
        Computer computer = new Computer();

        while (player.toBeContinued()) {
            playBaseballGame(player, computer);
        }

        printEndMessage();
    }

    private static void playBaseballGame(Player player, Computer computer) {
        computer.makeBaseballGameAnswer();
    }

    private static void printEndMessage() {
        System.out.println("프로그램이 종료됩니다.");
    }
}
