package baseball;

import utils.RandomUtils;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
        int targetValue = getRandomValue();
        Game.gameStart(targetValue, scanner);
    }

    private static int getRandomValue() {
        Set<Integer> set = new HashSet<>();
        int result = 0;
        int index = 1;

        do {
            set.add(RandomUtils.nextInt(1, 9));
        } while (set.size() < 3);

        for (Integer s : set) {
            result += s * index;
            index *= 10;
        }

        return result;
    }
}
