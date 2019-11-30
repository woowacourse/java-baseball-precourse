import java.util.Random;

public class Computer {
    private int[] numbers;
    private int[] result;

    public Computer() {
        numbers = new int[3];
        result = new int[2];
        number_generator();
    }

    public void number_generator() {
        Random rand = new Random();

        for (int i = 0; i < numbers.length; ++i) {
            numbers[i] = rand.nextInt(10);
            if (numbers[i] == 0)
                --i;
        }
    }

    
}