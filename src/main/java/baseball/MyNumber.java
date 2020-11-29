package baseball;

import java.util.ArrayList;
import java.util.List;

public class MyNumber {

    //세자리 숫자를 입력받을 것이기 때문에 상수로 3 설정
    static final int MY_NUM_LENGTH = 3;

    //입력받은 값이 세자리인지 아닌지 판단하는 메서드
    private boolean notInputThreeDigit(int inputNum) {
        return (inputNum < 100) || (inputNum > 999);
    }

    //세 숫자가 중복되는지를 검사하는 메서드
    private boolean checkDuplication(int n1, int n2, int n3) {
        return (n1 == n2) || (n2 == n3) || (n3 == n1);
    }

    //입력받은 숫자 자릿수를 분리하여 리스트로 반환하는 메서드
    private List<Integer> makeThreeMyNum(int inputNum) {
        List<Integer> myThreeNum = new ArrayList<>(MY_NUM_LENGTH);
        for (int i = 0; i < MY_NUM_LENGTH; i++) {
            String strNum = Integer.toString(inputNum);
            String str = Character.toString(strNum.charAt(i));
            myThreeNum.add(Integer.parseInt(str));
        }
        return myThreeNum;
    }

    //세자리인지 검사후 리스트로 저장하고, 중복 검사를 한다
    //위 조건을 만족하면 세 숫자를 리스트로 반환하고
    //조건을 만족하지 못하면 IllegalArgumentException을 발생시킨다.
    public List<Integer> myNumList(int inputNum) {
        List<Integer> myNumList;
        if (notInputThreeDigit(inputNum)) {
            throw new IllegalArgumentException();
        }
        myNumList = makeThreeMyNum(inputNum);
        if (checkDuplication(myNumList.get(0), myNumList.get(1), myNumList.get(2))) {
            throw new IllegalArgumentException();
        }
        return myNumList;
    }

}
