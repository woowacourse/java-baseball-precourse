package baseball;

public class BaseballGame {
    public static void gameStart() {
        while (true) {
            int[] compareValues = new int[2];
            String randomNumber;
            randomNumber = baseball.Computer.getRandomNumber();
            System.out.println(randomNumber);
            while (compareValues[0] != 3) {
                String inputNumber = baseball.User.pleaseInputNumber();
                compareValues = baseball.Referee.compareValues(randomNumber, inputNumber);
            }
            boolean gameEnd = baseball.Referee.gameEnd();
            if (gameEnd == true) {
                break;
            }
        }
    }
}
