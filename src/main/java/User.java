import java.util.Scanner;

public class User {
    private int[] user_numbers;
    private String input;

    public User() {
        user_numbers = new int[3];
    }

    public void input_numbers() {
        Scanner sc = new Scanner(System.in);
        input = sc.nextLine();
        for (int i = 0; i < user_numbers.length; ++i) {
            user_numbers[i] = input.charAt(i) - '0';
        }

    }
}
