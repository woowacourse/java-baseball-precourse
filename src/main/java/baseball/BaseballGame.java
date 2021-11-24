package baseball;

public class BaseballGame {
    private NumberComparator numberComparator;
    private String playerNumber;
    private String computerNumber;

    public void startGame() {

        numberComparator = new NumberComparator();

        setComputer();
        numberComparator.setComputerNumber(computerNumber);
        do {
            getPlayer();
            numberComparator.clear();
            numberComparator.setPlayerNumber(playerNumber);
            numberComparator.compareNumber();

            // getResult();
        } while (true); // continueGame()
    }

    private void getPlayer() {
        try {
            Player player = new Player();
            playerNumber = player.scanNumber();
            System.out.println("PLAYERNUM = " + playerNumber);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }

    public void setComputer() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        computerNumber = randomNumberGenerator.generateNumber();

        System.out.println("COMPNUM = " + computerNumber);
    }
}
