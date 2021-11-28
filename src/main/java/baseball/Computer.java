package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
    public Computer() {

    }

    public char[] pickNumber() {
        char[] number = new char[3];
        boolean trying = false;
        while(!trying) {
            number[0] = String.valueOf(Randoms.pickNumberInRange(1, 9)).charAt(0);
            number[1] = String.valueOf(Randoms.pickNumberInRange(1, 9)).charAt(0);
            number[2] = String.valueOf(Randoms.pickNumberInRange(1, 9)).charAt(0);
            if(!(number[0] == number[1] || number[1] == number[2] || number[2] == number[0])) {
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
        if (ballCount == 0) {
            System.out.print("낫싱");
        }
        System.out.println();
        if (strikeCount == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        return false;
    }


}
