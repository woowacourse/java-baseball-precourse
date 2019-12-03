package domain;

/**
 * @author :   김시영
 * @version :   1.0 2019년 11월 31일
 * @apiNote :   사용자 입력값과 컴퓨터에서 생성한 난수를 비교하는 클래스를 위한 인터페이스입니다.
 * @implSpec :  입력값과 난수를 비교하는 Method 구현
 */
@FunctionalInterface
public interface Validator {

    String compareRandomNumberWithUserNumber(int randomNumber, int userInput);
}
