package com.github.callmewaggs.javabaseballprecourse.baseball.player;

import com.github.callmewaggs.javabaseballprecourse.baseball.Ball;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserPlayer implements BallPlayer {
    private Ball ball;

    @Override
    public void prepareBall() {
        Scanner scan = new Scanner(System.in);
        while (true) {
            List<Integer> numbers = new ArrayList<>();
            System.out.print("숫자를 입력해주세요 : ");
            String userInput = scan.nextLine();

            if (!isValidate(numbers, userInput)) {
                System.out.println("1 ~ 9 까지의 3자리 숫자를 입력해 주세요.");
            } else {
                this.ball = new Ball(numbers);
                break;
            }
        }
    }

    private boolean isValidate(List<Integer> numbers, String userInput) {
        if (userInput.length() != 3)
            return false;
        for (char c : userInput.toCharArray()) {
            if (c >= '1' && c <= '9') {
                numbers.add(c - '0');
            } else
                return false;
        }
        return true;
    }

    @Override
    public Ball getBall() {
        return this.ball;
    }
}
