package baseball;

import camp.nextstep.edu.missionutils.Console;

public class BaseballGame {

    private RandomNumberGenerator randomNumberGenerator;
    private Player player;
    private String playerNumber;
    private String computerNumber;

    public void startGame() {
        setComputer();
        getPlayer();
        // verifyNumber();
        // getResult();
    }

    private void getPlayer() {
        Player player = new Player();
        playerNumber = player.scanNumber();
    }

    public void setComputer() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        computerNumber = randomNumberGenerator.generateNumber();

        System.out.println("COMPNUM = " + computerNumber);
    }
}
