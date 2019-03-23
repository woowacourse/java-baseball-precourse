import java.util.Scanner;

public class Game {

    String recieveNumber() {
        boolean flagForLength;
        boolean flagForNumber;
        String input;
        Scanner scan = new Scanner(System.in);
        CheckSomething check = new CheckSomething();

        while(true) {
            input = scan.nextLine();
            flagForLength = check.checkLength(input, 3);
            flagForNumber = check.checkNumberString(input);

            if (flagForLength == true && flagForNumber == true) {
                break;
            }
            else {
                System.out.println("");
            }
        }

        return input;
    }
}
