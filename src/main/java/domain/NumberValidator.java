package domain;

import lombok.Data;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

/**
 * @author :   김시영
 * @version :   2.0 2019년 12월 02일
 * @apiNote :   사용자 입력값과 컴퓨터에서 생성한 난수를 비교하는 인터페이스를 구현한 클래스입니다. (기능 : 두 숫자 비교, 결과 출력, 비교를 위한 리스트 배열 처리)
 */
@Data
public class NumberValidator implements Validator {
    private static final String DEFALUT_STRING_BLANK = "";
    private static final int DEFALUT_INT_ZERO = 0;
    private int strike = DEFALUT_INT_ZERO;
    private int ball = DEFALUT_INT_ZERO;

    /*
     * 사용자 입력 및 난수를 문자로 변환하여 처리하는 것이 좋을 것 같아, 배열과 리스트의 형태로 변환하였습니다.
     */
    @Override
    public String compareRandomNumberWithUserNumber(int randomNumber, int userInput) {
        strike = DEFALUT_INT_ZERO;
        ball = DEFALUT_INT_ZERO;

        List<String> randomNumberList = Arrays.asList(String.valueOf(randomNumber).split(DEFALUT_STRING_BLANK));
        String[] userInputArray = String.valueOf(userInput).split(DEFALUT_STRING_BLANK);
        this.compareListWithArray(userInputArray, randomNumberList);

        return this.printValidatedResult(strike, ball);
    }

    /*
     * 컴퓨터가 생성한 각 자리값이, 사용자 입력값의 각 자리값을 포함하고 있는지,
     * 포함하고 있다면 인덱스는 일치하는지를 통해 Strike, Ball 값을 결정하는 부분입니다.
     */
    public void compareListWithArray(String[] userInputArray, List<String> randomNumberList) {
        for (int i = 0; i < userInputArray.length; i++) {
            if (randomNumberList.get(i).equals(userInputArray[i])) {
                strike++;
            } else if (randomNumberList.contains(userInputArray[i])
                    && randomNumberList.indexOf(userInputArray[i]) != i) {
                ball++;
            }
        }
    }

    private String printValidatedResult(int strikeCount, int ballCount) {
        StringBuilder sb = new StringBuilder();

        if (strikeCount == DEFALUT_INT_ZERO && ballCount == DEFALUT_INT_ZERO) {
            sb.append("NOTHING");
        }
        if (strikeCount > DEFALUT_INT_ZERO) {
            sb.append("STRIKE : ").append(strikeCount).append(" ");
        }
        if (ballCount > DEFALUT_INT_ZERO) {
            sb.append("BALL : ").append(ballCount);
        }
        return sb.toString();
    }

}
