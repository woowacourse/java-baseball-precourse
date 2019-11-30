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

    private int check_strike(int user_number, int index) {
        int check = 0;
        if (user_number == numbers[index])
            ++check;
        return check;
    }

    private int check_boll(int user_number, int[] computer_numbers) {
        int check = 0;
        for (int i = 0; i < numbers.length; ++i) {
            if (computer_numbers[i] != 0 && user_number == computer_numbers[i]) {
                ++check;
            }
        }

        return check;
    }

    
}