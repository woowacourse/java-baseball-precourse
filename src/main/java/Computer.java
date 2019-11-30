import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

/**
 * Computer class - 컴퓨터의 기능을 정의
 *
 * @version         1.01 2019-11-30
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

    /**
     * 3자리 숫자를 입력받아 답인지 확인하고 결과를 출력하는 method
     * @param inputNumber 입력받은 3자리 숫자
     * @return Boolean 정답 여부
     */
    public Boolean checkAnswerNumber(int inputNumber) {
        int strike = 0;             // strike 갯수
        int ball = 0;               // ball 갯수

        /*
         * 1의 자리부터 한 자리씩 확인하며 같은 수가 같은 자리에 있으면 strike,
         * 다른 자리에 있으면 ball 갯수를 1씩 증가
         */
        for (int i = 2; i >= 0; i--){
            int place = inputNumber % 10;
            if (answerNumber.get(i) == place) {
                strike++;
            } else if (answerNumber.contains(place)) {
                ball++;
            }
            inputNumber /= 10;
        }

        /* 같은 수가 없으면 Nothing, 있다면 strike와 ball 갯수를 출력 */
        if (strike == 0 && ball == 0) {
            System.out.print("Nothing");
        }
        if (strike != 0) {
            System.out.print(strike + " 스트라이크 ");
        }
        if (ball != 0) {
            System.out.print(ball + "볼");
        }
        System.out.println();
        if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }

        return (strike == 3);           // strike가 3개면 정답
    }
}
