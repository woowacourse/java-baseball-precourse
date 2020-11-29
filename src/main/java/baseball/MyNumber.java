package baseball;

public class MyNumber {

    //세자리 숫자를 입력받을 것이기 때문에 상수로 3 설정
    static final int MY_NUM_LENGTH = 3;

    //입력받은 값이 세자리인지 아닌지 판단하는 메서드
    private boolean notInputThreeDigit(int inputNum) {
        return (inputNum < 100) || (inputNum > 999);
    }

}
