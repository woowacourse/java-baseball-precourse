import baseball.Application;
import org.junit.jupiter.api.Test;

public class NumberTest {

    @Test
    public void testNumberOfPlayerAndComputer() {
        String playerNumber = "369";
        Application.checkCorrectCondition(playerNumber);

        for (int i = 0; i < 100; i++) {
            String computerNumber = Application.getComputerNumber();
            System.out.println(playerNumber + " : " + computerNumber);
        }
    }

    @Test
    public void testCompareStrikeAndBall() {
        String playerNumber = Application.getComputerNumber();
        String computerNumber = Application.getComputerNumber();

        int[] strikeAndBall = getStrikeAndBallCount(playerNumber, computerNumber);
        int strike = strikeAndBall[0];
        int ball = strikeAndBall[1];

        System.out.println(playerNumber + " : " + computerNumber);
        System.out.println("S : " + strike + ", B : " + ball);
    }

    public int[] getStrikeAndBallCount(String playerNumber, String computerNumber) {
        int ball = 0;
        int strike = 0;
        String[] playerDigitArr = playerNumber.split("");
        for (int i = 0; i < playerDigitArr.length; i++) {
            int indexOfSameDigitOfComputerNumber = getIndexOfSameDigitOfComputerNumber(playerDigitArr[i], computerNumber);
            strike += getStrikeCount(indexOfSameDigitOfComputerNumber, i);
            ball += getBallCount(indexOfSameDigitOfComputerNumber, i);
        }
        int[] arr = {strike, ball};
        return arr;
    }
    public int getIndexOfSameDigitOfComputerNumber(String playerDigit, String computerNumber) {
        if (computerNumber.contains(playerDigit)) {
            return computerNumber.indexOf(playerDigit);
        }
        return -1;
    }

    public int getStrikeCount(int indexOfSameDigitOfComputerNumber, int indexOfSameDigitOfPlayerNumber) {
        if (indexOfSameDigitOfComputerNumber == indexOfSameDigitOfPlayerNumber) {
            return 1;
        }
        return 0;
    }

    public int getBallCount(int indexOfSameDigitOfComputerNumber, int indexOfSameDigitOfPlayerNumber) {
        if (indexOfSameDigitOfComputerNumber != indexOfSameDigitOfPlayerNumber && indexOfSameDigitOfComputerNumber >= 0) {
            return 1;
        }
        return 0;
    }

}
