import java.util.Scanner;

public class InputBaseballGame {
    private static Scanner sc = new Scanner(System.in);

    public static int inputUserNumber() {
        System.out.println("숫자를 입력해주세요 : ");
        return sc.nextInt();
    }
}
