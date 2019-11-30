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
    
    public int[] compare_number(int[] user_numbers) {
        int strike = 0;
        int boll = 0;
        int[] temp_computer_numbers = new int[3];
        System.arraycopy(numbers, 0, temp_computer_numbers, 0, numbers.length);

        for (int i = 0; i < user_numbers.length; ++i) {
            int check = check_strike(user_numbers[i], i);
            if (check == 1) {
                temp_computer_numbers[i] = 0;
                user_numbers[i] = 0;
            }
            strike += check;

        }
        for (int i = 0; i < user_numbers.length; ++i) {
            if (user_numbers[i] != 0) {
                boll += check_boll(user_numbers[i], temp_computer_numbers);
            }
        }
        set_result(strike, boll);
        return result;
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

    private void set_result(int strike, int boll) {
        result[0] = strike;
        result[1] = boll;
    }

    public void print_computer_numbers() {
        for (int i = 0; i < numbers.length; ++i) {
            System.out.println(numbers[i]);
        }

    }

    
}