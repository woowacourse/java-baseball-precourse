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

    /**
     *  입력값이 유효한 값인지 확인하는 메서드.
     *  유효한 값이란 세 자리수에 중복된 수가 없고, 각 수가 1~9 사이인 값이다.
     * @param input inputNumbers()에서 받아온 입력값.
     * @return  유효한 값이면 true반환, 아니면 false 반환
     */
    @Override
    public boolean isValid(String input) {
        if(input.length()!=3){
            return false;                                           /* input의 길이가 3이 아닌 경우 */
        }
        for(int i=0; i<input.length(); i++) {                       /* 각 자리마다 확인 */
            if ((input.charAt(i)<'1') && (input.charAt(i)>'9')) {
                return false;                                       /* 1이상 9이하의 수가 아닌 경우 */
            }
        }
        return (input.charAt(0) != input.charAt(1))
                && (input.charAt(0) != input.charAt(2))
                && (input.charAt(1) != input.charAt(2));
        /* 중복되는 수가 있으면 false, 없으면 true 반환 */
    }
}
