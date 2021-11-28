package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
    public Computer() {

    }

    public char[] pickNumber() {
        char[] number = new char[3];
        boolean trying = false;
            while(!trying) {
                number = String.valueOf(Randoms.pickNumberInRange(100, 999)).toCharArray();
                if(number[0] == number[1] || number[1] == number[2] || number[2] == number[0]) {
                    trying = true;
                }
            }
        return number;
    }

    public boolean compare(char[] userNumber, char[] comNumber) {
        int ballCount = 0;
        int strikeCount = 0;
        for (int i = 0; i < 3; i++) {
            if (userNumber[i] == comNumber[0]) {
                ballCount += 1;
            }
            if (userNumber[i] == comNumber[1]) {
                ballCount += 1;
            }
            if (userNumber[i] == comNumber[2]) {
                ballCount += 1;
            }
            if (userNumber[i] == comNumber[i]) {
                strikeCount += 1;
            }
        }
        ballCount = ballCount - strikeCount;
        if (ballCount != 0) {
            System.out.print(ballCount+"볼 ");
        }
        if (strikeCount != 0) {
            System.out.print(strikeCount+"스트라이크");
        }
        System.out.println();
        if (strikeCount == 3) {
            return true;
        }
        return false;
    }


}
