class BaseballGame {
    public static void main(String[] args) {
        Player player = new Player();
        Computer computer = new Computer();

        while (player.toBeContinued()) {
            playBaseballGame(player, computer);
        }

        endBaseballGame();
    }

    public static void playBaseballGame(Player player, Computer computer) {
        computer.makeBaseballGameAnswer();
    }

    public static void endBaseballGame() {
        System.out.println("프로그램이 종료됩니다.");
    }
}
