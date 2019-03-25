import java.util.Scanner;

public class CheckSomething {

    static boolean checkLength(String input, int length) {
        if (input.length() != length)
            return false;
        else
            return true;

    }

    static boolean checkNumberString(String input) {
        boolean flag =  true;
        for (int i = 0; i < input.length(); i++) {
            if (checkNumber(input.charAt(i)) == false) {
                flag = false;
                break;
            }
        }
        if (flag == false)
            return false;
        else
            return true;
    }

    static boolean checkNumber(char character) {
        if (character >= '1' && character <= '9')
            return true;
        else
            return false;
    }

    static boolean checkRecievedNumber(String number) {
        boolean flagForLength;
        boolean flagForNumber;

        flagForLength = checkLength(number, 3);
        flagForNumber = checkNumberString(number);

        if (flagForLength == true && flagForNumber == true)
            return true;
        else
            return false;
    }

    static boolean checkUserThought() {
        Scanner s = new Scanner(System.in);
        String input;

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        while(true) {
            input = s.nextLine();
            if (input.equals("1") || input.equals("2"))
                break;
            else
                System.out.println("공백을 넣지 말고, 1 또는 2만 입력하시기 바랍니다.");
        }
        if (input.equals("1")) {
            return true;
        }
        else
            return false;
    }

}
