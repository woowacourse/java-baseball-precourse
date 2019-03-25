import java.util.Random;

/**
 * Number 클래스는 baseballGame에 필요한 숫자 생성과 입력을 받는 class
 *
 * @version         1.0 2019년 5월 21일
 * @author          이중혁
 */
public class Number {

    /**
     * 난수 생성 메소드
     * @return int형
     */
    public static int createRandomNumber(){
        Random createNumber=new Random();   //난수 생성을 쓰기위한 인스턴스 생성
        int randomNumber = createNumber.nextInt(900)+100;   //100~999까지 난수를 생성하여 randomNumber에 저장

        return randomNumber;    //생성된 randomNumber 반환
    }
}
