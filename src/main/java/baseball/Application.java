package baseball;

import java.util.Scanner;
import utils.RandomUtils;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행

        StringBuilder randomNum = new StringBuilder();
        for (int i = 0; i<3; i++) {
            randomNum.append(RandomUtils.nextInt(1, 9));
        }
        int answer = Integer.parseInt(randomNum.toString());
        System.out.println(answer);
    }
}
