import java.util.Random;

public class Numbers {
    private static Random random = new Random();

    private int firstNumber;
    private int secondNumber;
    private int thirdNumber;

    public Numbers() {
        firstNumber = makeRandomNumber();
        do {
            secondNumber = makeRandomNumber();
        } while (secondNumber != firstNumber);
        do {
            thirdNumber = makeRandomNumber();
        } while ((thirdNumber != firstNumber) && (thirdNumber != secondNumber));
    }

    private int makeRandomNumber() {
        return random.nextInt(9) + 1;
    }
}