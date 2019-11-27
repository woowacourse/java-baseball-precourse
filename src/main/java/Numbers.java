import java.util.Random;

public class Numbers {
    private static Random random = new Random();

    private int firstNumber;
    private int secondNumber;
    private int thirdNumber;

    public Numbers() {
        firstNumber = makeRandomNumber();
        secondNumber = makeRandomNumber();
        thirdNumber = makeRandomNumber();
    }

    private int makeRandomNumber() {
        return random.nextInt(9) + 1;
    }
}