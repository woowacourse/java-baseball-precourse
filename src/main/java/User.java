import java.util.Scanner;

public class User {
    private int[] userNumber;
    private Computer computer;

    User(){
        computer = new Computer();
    }

    int[] getUserNumber(){
        return userNumber;
    }

    /*
     사용자가 추측한 번호를 문자열 형태로 수집
     문자열 형태의 번호가 유효한지 검사, 정수 배열로 변환
     */

    void inputUserNumber(){
        Scanner scanner = new Scanner(System.in);
        String number;
        int transNumber;
        userNumber = new int[3];

        do{
            System.out.print("숫자를 입력하세요: ");
            number = scanner.next();
        }while(!computer.checkUserNumber(number));

        transNumber = Integer.parseInt(number);
        for(int i=2; i>=0; i--){
            userNumber[i] = transNumber % 10;
            transNumber /= 10;
        }
    }
}
