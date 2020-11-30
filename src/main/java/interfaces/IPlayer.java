package interfaces;

import java.util.Scanner;
import baseball.BaseballGameNumber;

public interface IPlayer {
    public void inputThreeNumber(Scanner scanner);

    public BaseballGameNumber getBaseballGameNumber();
}
