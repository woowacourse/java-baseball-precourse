package baseball;

public class BaseballGame {
    private String playerNumber;
    private String computerNumber;

    public void startGame() {
        setComputer();
        NumberComparator numberComparator = new NumberComparator();
        numberComparator.setComputerNumber(computerNumber);
        do {
            getPlayer();
            numberComparator.run(playerNumber);
            PrintResult printResult = new PrintResult();
            printResult.setNumberComparator(numberComparator);
            printResult.result();
        } while (continueGame());
    }

    private boolean continueGame() {
        if (computerNumber.equals(playerNumber)) {
            return false;
        }

        return true;
    }

    private void getPlayer() {
        try {
            Player player = new Player();
            playerNumber = player.scanNumber();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }

    public void setComputer() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        computerNumber = randomNumberGenerator.generateNumber();
    }
}
