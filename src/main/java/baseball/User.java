/*
 *  @(#)User.java       1.00    2019/03/23
 *
 *  Copyright   (c) 2019 Myungki Sa.
 *  Computer Science Engineering, Java, Daejeon, Korea
 *  All rights reserved.
 */

package baseball;

import java.io.IOException;

/**
 * User Class는 사용자를 위한 클래스이다.
 * Player interface를 구현한다.
 * 인스턴스 변수인 numbers 배열이 있다. 이 배열은 사용자가 입력한 수를 저장하기 위한 배열이다.
 * 게임을 진행하면서 입출력과 저장을 담당하는 메서드들이 있다.
 *
 * @version        1.00     2019년   3월  23일
 * @author         사명기
 */
public class User implements Player{

    /** 인스턴스 변수 numbers는 User가 입력한 세 수를 저장하기위한 배열 */
    private int[] numbers;

    /**
     *  매개변수가 없는 기본 생성자
     */
    public User(){
    }

    /**
     * 인스턴스 변수 numbers의 setter
     * @param numbers   사용자가 입력하는 세 자리로 된 수의 배열
     */
    private void setNumbers(int[] numbers){
        this.numbers=numbers;
    }

    /**
     * 인스턴스 변수인 numbers 배열의 getter
     * @return numbers  인스턴스 변수인 numbers 배열
     */
    public int[] getNumbers(){
        return numbers;
    }

    /**
     * [README.md]<1-i>
     * 사용자의 입력을 받는 메서드.
     * @return String   사용자의 입력 값을 반환
     * @throws IOException  어떠한 입출력 예외의 발생을 통지하는 시그널을 발생
     */
    public String inputNumbers() throws IOException {
        return br.readLine();
    }


    @Override
    public boolean isValid(String input) {
        return false;
    }
}
