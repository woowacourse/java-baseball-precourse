/*
 * Pitcher.java
 *
 * 2019/12/3
 */
import java.lang.*;

/**
 * Precourse 1주차
 * Pitcher.java
 * Purpose : 숫자 야구게임에서 사용자에 해당하는 클래스
 *
 *   @version         1.00 2019/12/3
 *   @author          김태헌
 */
public class Pitcher {
    private static final int PITCHING_COUNT = 3;        //사용자가 던지는 투구 횟수
    private int[] pitching;                             //사용자의 투구 값에 대한 정 배열

    /**
     * Pitcher class 의 default 생성자. pitching 에 대한 배열을 생성해주고 0으로 초기화 해준다. 사용자로부터 pitching 값을 전달받지 못했거나,
     * 인스턴스가 올바른 방법으로 생성되지 않은 경우이므로, 게임을 수행할 수 없도록 값을 0으로 초기화 해준다.
     */
    public Pitcher() {
        pitching = new int[PITCHING_COUNT];

        for (int i = 0; i < PITCHING_COUNT; i++) {
            pitching[i] = 0;
        }
    }

    /**
     * Pitcher class 의 생성자. default 생성자와 마찬가지로 배열을 초기화 해주나, 올바른 세자리 정수를 parameter 로 받은 경우,
     * 세자리 숫자의 순서에 맞게 배열을 초기화 해준다.
     *
     * @param n Pitching 값에 대한 3자리 정수
     */
    public Pitcher(int n) {
        this();
        if(n <100 || n>=1000){

            /* 사용자로부터 입력받은 값이 3자리 정수가 아닌 경우 에러를 출력해주고 pitching 값을 0으로 유지한다. */
            System.out.println("Error! 올바른 세자리 숫자를 입력해 주세요!");
        }
        else {

            /* 사용자로부터 입력받은 값이 3자리 정수인 경우, 각 자릿수에 해당하는 정수를 배열에 순서대로 넣어준다. */
            for (int i = PITCHING_COUNT - 1; i >= 0; i--) {
                pitching[i] = n % 10;
                n /= 10;
            }
        }
    }

    /**
     * int[] getPitching 메소드. 인스턴스 변수인 pitching 배열을 반환해준다.
     *
     * @return pitching 의 clone object
     *
     */
    public int[] getPitching() {
        return pitching.clone();        //pitching 값이 수정될 수 있으므로 clone 메소드를 사용하여 return 해준다.
    }
}
