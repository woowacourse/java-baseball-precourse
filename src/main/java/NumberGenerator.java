import java.util.HashMap;
import java.util.Random;

public class NumberGenerator {
    private HashMap<Integer, Integer> numberMap;
    private Random random;
    private static final int DIGITS = 3;

    public NumberGenerator() {
        this.numberMap = new HashMap<>();
        this.random = new Random();
    }

    public HashMap<Integer, Integer> generateNumbers() {
        int randomNumber;
        for (int i = 0; i < DIGITS; i++) {
            randomNumber = pickRandomNumber();
            this.numberMap.put(randomNumber, i);
        }
        return this.numberMap;
    }

    private int pickRandomNumber() {
        int randomNumber;
        while (true) {
            randomNumber = this.random.nextInt(9) + 1;
            if (isNotPickedYet(randomNumber)) {
                return randomNumber;
            }
        }
    }

    private boolean isNotPickedYet(int pickedNumber) {
        return !this.numberMap.keySet().contains(pickedNumber);
    }


}
