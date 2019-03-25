/*
 * BaseBall 클래스는 야구게임의 기본 규칙과 로직을 담는다.
 * 메서드별 @param, @return 표시한다.
 */
import java.util.Random;

public class BaseBall {
    /**
     * @return  3자리 랜덤 숫자
     */
    int getRandomNumber() {
        int result;
        Random rd = new Random();
        result = rd.nextInt(899) + 100;
        return result;
    }

    /**
     * @return 3자리 게임에 쓸 수 있는 랜덤 숫자
     */
    int getGameNumber() {
        int gameNumber;

        do{
            gameNumber = getRandomNumber();
        }while(hasZero(gameNumber) || isDuplicate(gameNumber));

        return gameNumber;
    }

    /**
     *
     * @param   string 문자 형식의 숫자
     * @return  0을 포함하면 true
     */
    boolean hasZero(String string) {
        return string.contains("0");
    }

    /**
     * Overload
     *
     * @param number 세자리 숫자
     * @return 0을 포함하면 true
     */
    boolean hasZero(int number) {
        return hasZero(Integer.toString(number));
    }
}
