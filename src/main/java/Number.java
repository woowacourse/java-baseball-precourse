import java.util.Random;

/**
 * Number 클래스는 baseballGame에 필요한 숫자 생성과 입력을 받는 클래스 입니다.
 *
 * @version         1.0 2019년 3월 25일
 * @author          이중혁
 */
public class Number {

    /*100~999까지의 난수를 생성하는 메소드*/
    public static int createRandomNumber(){
        Random createNumber=new Random();   //난수 인스턴스 생성
        int randomNumber = createNumber.nextInt(900)+100;   //100~999까지 난수 저장

        return randomNumber;
    }
}
