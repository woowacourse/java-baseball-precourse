package baseball;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Referee referee = new Referee();
        final String result = referee.compare(Arrays.asList(1, 2, 3), Arrays.asList(1, 2, 3));
        System.out.println(result); // 3 스트라이크
    }
}
