package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import constant.SystemMessage;
import java.util.ArrayList;
import java.util.LinkedHashSet;

public class Computer {
    private ArrayList<Integer> randomNumberList = new ArrayList<>();

    public void decideRandomNumber() {
        makeRandomNumberList(makeRandomNumber());
    }

    public boolean canFinish(int predict) {
        int strikeCount = calculateBallCount(predict);
        if (strikeCount == 3) return true;
        return false;
    }

    private LinkedHashSet<Integer> makeRandomNumber() {
        LinkedHashSet<Integer> randomNumberSet = new LinkedHashSet<>();
        while (randomNumberSet.size() < 3) {
            randomNumberSet.add(Randoms.pickNumberInRange(1, 9));
        }
        return randomNumberSet;
    }

    private void makeRandomNumberList(LinkedHashSet<Integer> randomNumberSet) {
        for (int num : randomNumberSet) {
            randomNumberList.add(num);
        }
    }

    private int calculateBallCount(int predict) {
        int strike = SystemMessage.FIRST_VALUE;
        int ball = SystemMessage.FIRST_VALUE;
        ArrayList<Integer> predictList = makeNumberToList(predict);
        for (int i = 0; i < predictList.size(); ++i) {
            if (randomNumberList.get(i) == predictList.get(i)) {
                ++strike;
                continue;
            }
            if (randomNumberList.contains(predictList.get(i))) {
                ++ball;
            }
        }
        printBallCount(strike, ball);
        return strike;
    }

    private ArrayList<Integer> makeNumberToList(int number) {
        ArrayList<Integer> list = new ArrayList<>();
        while (number > 0) {
            list.add(0, number % 10);
            number /= 10;
        }
        return list;
    }

    private void printBallCount(int strike, int ball) {
        if (ball != 0) {
            System.out.printf("%d%s ", ball, SystemMessage.BALL);
        }
        if (strike != 0) {
            System.out.printf("%d%s", strike, SystemMessage.STRIKE);
        }
        if (ball == 0 && strike == 0) {
            System.out.printf("%s", SystemMessage.NOTHING);
        }
        System.out.println();
    }

}
