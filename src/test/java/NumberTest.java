import baseball.Referee;
import baseball.Number;
import org.junit.jupiter.api.Test;

public class NumberTest {

    @Test
    public void testComputerNumberValidity() {
        Number number = new Number();
        String playerNumber = "369";
        number.checkCorrectCondition(playerNumber);

        for (int i = 0; i < 100; i++) {
            String computerNumber = number.getComputerNumber();
            System.out.println(playerNumber + " : " + computerNumber);
        }

    }

    @Test
    public void testStrikeAndBallCount() {
        Number number = new Number();
        Referee referee = new Referee();

        String playerNumber = number.getComputerNumber();
        String computerNumber = number.getComputerNumber();

        int[] strikeAndBall = referee.getStrikeAndBallCount(playerNumber, computerNumber);
        int strike = strikeAndBall[0];
        int ball = strikeAndBall[1];

        System.out.println(playerNumber + " : " + computerNumber);
        System.out.println("S : " + strike + ", B : " + ball);
    }
}
