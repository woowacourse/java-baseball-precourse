/*
* Computer.java
*
* version 1.0        2019.03.27
*
* JDK 1.8
*
* Copyright (c) 2019 Jong Min Lee.
* All right reserved.
*/

package com;

/*
* 사용자의 상대편인 컴퓨터에 관련된 클래스 입니다.
* 임의의 수 만들기, 컴퓨터 수 가져오기, 초기화 기능을 갖고 있습니다.
*
* @version 1.00 2018.3.27
* @author 이종민
*/

public class Computer {
    private int[] numberTable;
    private String guessNumber ="";
    private int numberLength;

    public Computer(int length) {
        numberLength = length;
        numberTable = new int[10];      /* 1~9까지 숫자중복 확인 위해서 사용여부 확인하는 변수 */
    }

    public void makeNumber() {
        int randomNum;
        int numberCount = numberLength;

        while (numberCount != 0) {
            randomNum = (int) (Math.random() * 9) + 1;

            if (numberTable[randomNum] == 0 ) { /* 1 이 나오게 되면 이미 나온수가 된다. */
                numberTable[randomNum] = 1;     /* 이미 나온 수에 1을 삽입 */
                numberCount--;                  /* 정해진 수만큼 임의의 수를 만들기 위해서 */
                guessNumber += Integer.toString(randomNum); /* 확인이 끝난 수는 String으로 붙인다.*/
            }
        }

    }

}
