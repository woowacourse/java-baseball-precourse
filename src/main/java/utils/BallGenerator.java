package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static baseball.domain.GameInfomation.*;
import static baseball.domain.GameInfomation.INPUT_USER_BALL_MESSAGE;
import static utils.InputValidation.*;

public class BallGenerator {

    public List<Integer> createComputerBall() {
        List<Integer> balls = new ArrayList<>();
        int num;
        while(balls.size() < NUMBER_LENGTH) {
            num = RandomUtils.nextInt(NUMBER_RANGE_ONE, NUMBER_RANGE_NINE);
            if(!balls.contains(num)) {
                balls.add(num);
            }
        }
        return balls;
    }

    public List<Integer> createUserBall(Scanner sc) {
        System.out.print(INPUT_USER_BALL_MESSAGE);
        String num = sc.next();
        validateNumberLength(num);
        validateIsOnlyDigit(num);
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
