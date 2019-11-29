import java.util.InputMismatchException;
import java.util.Scanner;

public class User {
    Scanner s = new Scanner(System.in);
    private int userInput;

    public void inputNumber() {
        System.out.print("숫자를 입력해주세요 : ");

        try {
            userInput = s.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("제대로 된 3자리 수를 입력해주세요!");
        }

        if(!checkInput(userInput)) {
            System.out.println("제대로 된 3자리 수를 입력해주세요!");
            inputNumber();
        }
    }

    public boolean checkInput(int input) {
        // input이 3자리 수가 아닌 경우
        if(input < 100) {
            return false;
        } else if(input >= 1000) {
            return false;
        }

        // input에 0이 들어가 있는 경우
        for(; input > 0; input /= 10) {
            if(input % 10 == 0) {
                return false;
            }
        }

        return true;
    }

    public int getInput() {
        return userInput;
    }
}