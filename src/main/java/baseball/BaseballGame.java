package baseball;

public class BaseballGame {

    private RandomNumberGenerator randomNumberGenerator;

    public void startGame() {
        setComputer();
        // getPlayer();
        // verifyNumber();
        // getResult();
        // continueGame() using do..while
    }

    public void setComputer() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        String computer = randomNumberGenerator.generateNumber();

        System.out.println(computer);
    }
}
