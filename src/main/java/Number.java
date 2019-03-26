import java.util.Random;
import java.util.Scanner;

/**
 * Number 클래스는 baseballGame에 필요한 숫자 생성과 입력을 받는 클래스 입니다.
 *
 * @version         1.0 2019년 3월 25일
 * @author          이중혁
 */
public class Number {

    /* 100~999까지의 난수를 생성하는 메소드 */
    public static int[] createRandomNumber(){

        Random createNumber=new Random();

        int[] randomNumber = new int[3];                                // 난수 저장 배열 생성

        /* 무한반복 생성후 난수 생성시 종료 */
        while(true)
        {
            randomNumber[0] = createNumber.nextInt(9)+1;        // 첫번째 난수 생성
            randomNumber[1] = createNumber.nextInt(9)+1;        // 두번째 난수 생성
            randomNumber[2] = createNumber.nextInt(9)+1;        // 세번째 난수 생성

            if((randomNumber[0] != randomNumber[1])
                    && (randomNumber[1] != randomNumber[2])
                    && (randomNumber[0] != randomNumber[2])) {

                /* 각각 자리수가 겹치지 않을경우 */
                break;                                                  // 무한반복 종료
            }
        }

        return randomNumber;
    }

    /* 사용자 입력 받는 메소드 */
    public static int inputUserNumber(){

        int userNumber=0;                                               // 사용자 입력 변수생성
        Scanner getNumber = new Scanner(System.in);                     // Scanner 인스턴스 생성

        userNumber=getNumber.nextInt();                                 // 키보드 숫자 입력

        if((userNumber<100) || (userNumber>999)){

            /* userNumber가 3자리 값이 아닐경우 예외처리 */
            userNumber = -1;        // 3자리 값이 아닐경우 userNumber에 -1을 대입하여 예외 처리
        }

        return userNumber;
    }
}
