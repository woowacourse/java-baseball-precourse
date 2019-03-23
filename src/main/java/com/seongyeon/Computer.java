package com.seongyeon;

public class Computer {

    static final int THREE_STRIK = 3;

    private int firstNum, secondNum, thirdNum;

    //컴퓨터가 1~9 의 중복되지 않는 난수 3개를 생성한다.
    public void makeNum() {

        do {
            firstNum = (int) (Math.random() * 8) + 1;
            secondNum = (int) (Math.random() * 8) + 1;
            thirdNum = (int) (Math.random() * 8) + 1;
        } while (firstNum == secondNum || thirdNum == secondNum || firstNum == thirdNum);

    }

    //저장 되어 있는 난수와 입력받은 3자리 수를 비교 후 결과를 출력한다. 
    public boolean checkNum(int num) {

        boolean isThreeStrike = false;
        int strike = 0, ball = 0;
        int firstInputNum, secondInputNum, thirdInputNum;

        firstInputNum = num / 100 % 10;
        secondInputNum = num / 10 % 10;
        thirdInputNum = num % 10;

        if (firstInputNum == firstNum) {
            strike++;
        }
        if (secondInputNum == secondNum) {
            strike++;
        }
        if (thirdInputNum == thirdNum) {
            strike++;
        }

        if ((firstInputNum == secondNum) || (firstInputNum == thirdNum)) {
            ball++;
        }
        if ((secondInputNum == firstNum) || (secondInputNum == thirdNum)) {
            ball++;
        }
        if ((thirdInputNum == secondNum) || (thirdInputNum == firstNum)) {
            ball++;
        }

        if (strike == THREE_STRIK) {
            System.out.println(strike + " 스트라이크");
            isThreeStrike = true;
        }

        if (strike > 0 && ball > 0) {
            System.out.println(strike + " 스트라이크 " + ball + " 볼");
        } else if (strike > 0 && ball == 0) {
            System.out.println(strike + " 스트라이크");
        } else if (strike == 0 && ball > 0) {
            System.out.println(ball + " 볼");
        } else {
            System.out.println("낫싱");
        }

        return isThreeStrike;
    }
}
