package baseball;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        boolean playing = true;

        Integer number;
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
        while (playing) {
            System.out.print("숫자를 입력해주세요 : ");
            if (scanner.hasNextInt()) {
                number = scanner.nextInt();
                System.out.println("입력숫자: " + number);
            } else {
                System.out.println("숫자를 입력해주세요 : ");
            }
        }
    }

}
