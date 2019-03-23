import java.util.Scanner;

public class Game {

    String recieveNumber() {
        boolean flag;
        String input;
        Scanner scan = new Scanner(System.in);
        CheckSomething check = new CheckSomething();

        while(true) {
            System.out.print("숫자를 입력해주세요 : ");
            input = scan.nextLine();
            flag = check.checkRecievedNumber(input);

            if (flag) {
                break;
            }
            else {
                System.out.println("공백을 제외한 3자리 숫자(1~9)를 입력하셔야 합니다.");
            }
        }

        return input;
    }

    String generateNumber(int length) {
        int random;
        char zero = '1';
        String number = "";

        for (int i=0; i<3; i++) {
            random = (int) (Math.random() * 9);
            zero = (char) (zero + random);
            number += zero;
            zero = '1';
        }

        return number;
    }
}
