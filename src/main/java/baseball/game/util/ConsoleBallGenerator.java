package baseball.game.util;

import baseball.game.collection.Balls;

import java.util.*;

import static baseball.application.GameManager.GAME_SIZE;

public class ConsoleBallGenerator implements BallGenerator {
    @Override
    public Balls getBalls(int size) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("숫자를 입력해 주세요. ");
        List<Integer> numSet = getUserInput(scanner.nextInt());
        return new Balls(numSet);
    }

    private List<Integer> getUserInput(int number) {
        if (isNotEffectiveNumber(number)) {
            throw new IllegalArgumentException();
        }
        List<Integer> res = new ArrayList<>();
        int tmpVal = number;
        for (int num = GAME_SIZE - 1; num >= 0; num--) {
            int val = (int) Math.pow(10, num);
            int data = tmpVal / val;
            inputData(res, data);
            tmpVal %= val;
        }
        return res;
    }

    private void inputData(List<Integer> res, int data) {
        checkDuplicate(res, data);
        res.add(data);
    }

    private void checkDuplicate(List<Integer> res, int data) {
        if (res.contains(data)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isNotEffectiveNumber(int number) {
        return number < Math.pow(10, GAME_SIZE - 1) || number >= Math.pow(10, GAME_SIZE);
    }
}
