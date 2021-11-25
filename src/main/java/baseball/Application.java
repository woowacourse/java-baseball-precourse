package baseball;

public class Application {
    public static void main(String[] args) {

        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

        String randomNumber = String.valueOf(randomNumberGenerator.makeRandomNumber(3));

    }
}
