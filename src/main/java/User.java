import java.util.Scanner;

public class User {
    private int[] userNumber;
    private Computer computer;

    User(){
        computer = new Computer();
    }

    int[] get_userNumber(){
        return userNumber;
    }

    void input_userNumber(){
        Scanner scanner = new Scanner(System.in);
        String number;
        int transNumber;
        userNumber = new int[3];

        do{
            System.out.print("숫자를 입력하세요: ");
            number = scanner.next();
        }while(!computer.check_userNumber(number));

        transNumber = Integer.parseInt(number);
        for(int i=2; i>=0; i--){
            userNumber[i] = transNumber % 10;
            transNumber /= 10;
        }
    }
}
