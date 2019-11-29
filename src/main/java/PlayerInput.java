import java.util.Scanner;

public class PlayerInput {

    public int[] getInput() {
        System.out.print("숫자를 입력해주세요: ");
        Scanner sc = new Scanner(System.in);

        String str_input = sc.next();
        int [] input = new int[3];

        input[0] = str_input.charAt(0);
        input[1] = str_input.charAt(1);
        input[2] = str_input.charAt(2);

        return input;
    }
}