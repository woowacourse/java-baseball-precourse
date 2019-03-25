import java.util.Random;
import java.util.Scanner;

/**
 * Number 클래스는 baseballGame에 필요한 숫자 생성과 입력을 받는 클래스 입니다.
 *
 * @version         1.0 2019년 3월 25일
 * @author          이중혁
 */
public class Number {

    /*100~999까지의 난수를 생성하는 메소드*/
    public static int createRandomNumber(){

        Random createNumber=new Random();   // 난수 인스턴스 생성
        int randomNumber = createNumber.nextInt(900)+100;   // 100~999까지 난수 저장

        return randomNumber;
    }

    /*사용자 입력 받는 메소드 */
    public static int inputUserNumber(){

        int userNumber=0;   // 사용자 입력 변수생성
        Scanner getNumber = new Scanner(System.in);     // Scanner 인스턴스 생성

        userNumber=getNumber.nextInt();     // 키보드 숫자 입력

        if((userNumber<100) || (userNumber>999)){

            /* userNumber가 3자리 값이 아닐경우 예외처리 */
            userNumber = -1;    // 3자리 값이 아닐경우 userNumber에 -1을 대입하여 예외 처리
        }

        return userNumber;
    }
}
