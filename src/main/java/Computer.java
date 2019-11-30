import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

/**
 * Computer class - 컴퓨터의 기능을 정의
 *
 * @version         1.00 2019-11-30
 * @author          김범준(ddaaac)
 */
public class Computer {
    /* 컴퓨터는 랜덤한 숫자를 만들거나, 답을 입력받아 결과를 출력할 수 있음 */

    /** 답이 될 자리수 */
    private static int numberOfDigit = 3;

    /** 컴퓨터가 만들어낼 3자리 수를 List 형태로 저장 */
    private List<Integer> answerNumber;

    /** 랜덤한 1~9의 수로 이루어진 3자리 수를 answerNumber 변수에 저장하는 method */
    public void makeAnswerNumber() {
        /* 후보 숫자들을 생성하고 하나씩 빼서 answerNumber 변수에 추가하는 방식으로 중복 피함 */

        List<Integer> candidate = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        answerNumber = new ArrayList<>(numberOfDigit);                                  // answerNumber 크기 3으로 초기화

        for (int i = 0; i < 3; i++) {
            int randomIndex = (int) (Math.random() * candidate.size());         // 후보 숫자 선택
            answerNumber.add(candidate.get(randomIndex));                       // answerNumber 변수에 추가
            candidate.remove(randomIndex);                                      // 후보 숫자 제거
        }
    }
}
