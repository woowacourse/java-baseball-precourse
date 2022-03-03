package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;


public class Application {
    public static List<Integer> comNum = new ArrayList<>();
    public static int num1, num2, num3;

    public static void addComNumber() {
        int temp;
        while (comNum.size()<3) {
            temp = Randoms.pickNumberInRange(1,9);
            if (!comNum.contains(temp)) {
                comNum.add(temp);
            }
        }
    }
    public static void playerNumber() {
        String sNum = Console.readLine();
        int allNum = Integer.parseInt(sNum);
        num1 = allNum/100;
        num2 = (allNum-num1*100)/10;
        num3 = allNum-num1*100-num2*10;
    }

    public static List<Integer> judge() {
        List<Integer> ballCount = new ArrayList<>();
        ballCount.add(0);
        ballCount.add(0);
        if (num1 == comNum.get(0)) {
            ballCount.set(0,ballCount.get(0)+1);
        } else if (num1 == comNum.get(1) || num1 == comNum.get(2)) {
            ballCount.set(1,ballCount.get(1)+1);
        }

        if (num2 == comNum.get(1)) {
            ballCount.set(0,ballCount.get(0)+1);
        } else if (num2 == comNum.get(0) || num2 == comNum.get(2)) {
            ballCount.set(1,ballCount.get(1)+1);
        }

        if (num3 == comNum.get(2)) {
            ballCount.set(0,ballCount.get(0)+1);
        } else if (num3 == comNum.get(0) || num3 == comNum.get(1)){
            ballCount.set(1,ballCount.get(1)+1);
        }
        return ballCount;
    }

    public static void printBallCount(List<Integer> ballcount){
        if (ballcount.get(0) == 0 && ballcount.get(1) == 0){
            System.out.println("낫싱");
        } else if (ballcount.get(0) == 0 && ballcount.get(1) !=0) {
            System.out.printf("%d볼\n",ballcount.get(1));
        } else if (ballcount.get(1) == 0 && ballcount.get(0) !=0) {
            System.out.printf("%d스트라이크\n",ballcount.get(0));
        } else {
            System.out.printf("%d볼 %d스트라이크\n",ballcount.get(1),ballcount.get(0));
        }
    }

    public static void main(String[] args) {
        addComNumber();
        //System.out.println(comNum);
        while(true){
            playerNumber();
            List<Integer> ballcount = judge();
            printBallCount(ballcount);
            if (ballcount.get(0) == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
                break;
            }
        }

    }


}
