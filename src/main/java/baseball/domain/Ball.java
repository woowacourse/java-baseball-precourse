package baseball.domain;

import utils.RandomUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static baseball.domain.Number.*;
import static utils.InputValidation.*;

public class Ball {

    public List<Integer> computerBallGenerator() {
        List<Integer> balls = new ArrayList<>();
        int num;
        while(balls.size() < NUMBER_COUNT) {
            num = RandomUtils.nextInt(NUMBER_RANGE_ONE, NUMBER_RANGE_NINE);
            if(!balls.contains(num)) {
                balls.add(num);
            }
        }
        return balls;
    }

    public List<Integer> userBallGenerator(Scanner sc) {
        System.out.print("숫자를 입력해주세요 : ");
        String num = sc.next();
        validateNumberCount(num);
        validateNumberRange(num);
        validateNumberDuplicate(num);

        return parseStringToIntegerList(num);
    }

    private List<Integer> parseStringToIntegerList(String num) {
        return Arrays.stream(num.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
