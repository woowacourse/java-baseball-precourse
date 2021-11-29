package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.stream.Stream;

public class Application {
    public static void main(String[] args) {
        boolean flag = true;
//        flag 가 true(2)가 되면 while 문이 종료되면서 게임 종료
        while (flag) {
            int[] randomNum = randomNum();

            int[] arrayNum = inputNum();
            arrayNumFlag(arrayNum);
            int strike = strikeCount(arrayNum,randomNum);
            int ball = ballCount(strike,arrayNum,randomNum);
            flag = getFlag();
        }
    }


    private static boolean getFlag() {
        boolean flag;
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String reStart = Console.readLine();
        if (reStart.equals("1")) {
            flag = true;
        }
        else {
            flag = false;
        }
        return flag;
    }

    //    랜덤으로 숫자 3개를 생성하는 매소드
    private static int[] randomNum() {
        int first = Randoms.pickNumberInRange(1, 9);
        int second;
        int third;
        while (true) {
            second = Randoms.pickNumberInRange(1, 9);
            if (second != first) break;
        }
        while (true) {
            third = Randoms.pickNumberInRange(1, 9);
            if (third != second && third != first) break;
        }
        int[] randomNum = {first,second,third};
        return  randomNum;
    }
//    숫자를 입력받을 때 사용하는 매소드
    private static int[] inputNum() {
        System.out.print("숫자를 입력해주세요 : ");
        String inputNum = Console.readLine();
        int[] arrayNum = Stream.of(inputNum.split("")).mapToInt(Integer::parseInt).toArray();
        return arrayNum;
    }
//    숫자가 3개가 맞는지 확인하는 매소드
    private static void arrayNumFlag(int[] arrayNum) {
        if (arrayNum.length != 3) throw  new IllegalArgumentException();
    }

//    스트라이크의 개수를 알려주는 매소드
    private static int strikeCount(int[] arrayNum, int[] randomNum) {
        int strike = 0;
        for (int i = 0; i < 3; i++) if (arrayNum[i] == randomNum[i]) strike++;
        return strike;
    }
//    볼의 개수를 알려주는 매소드
    private  static  int ballCount(int strike, int[] arrayNum, int[] randomNum) {
        int ball = 0;
        for (int i = 0;  i < 3; i++) for (int j = 0; j < 3; j++) if (randomNum[i] == arrayNum[j]) ball++;
        ball -= strike;
        return ball;
    }
}