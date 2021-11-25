package baseball;
import baseball.RandomGenerator;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        //TODO: 숫자 야구 게임 구현
        ArrayList<Integer> numbers = new ArrayList<Integer>();

        //Random test
        numbers = RandomGenerator.RandomGenerator();
        for (int i = 0; i < numbers.size(); i++) {
            System.out.print(numbers.get(i));
        }
    }
}
