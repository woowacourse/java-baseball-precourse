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

}
