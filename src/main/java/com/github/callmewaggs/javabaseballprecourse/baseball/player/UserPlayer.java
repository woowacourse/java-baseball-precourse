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
            System.out.print("숫자를 입력해주세요 : ");
            String userInput = scan.nextLine();

            try {
                List<Integer> numbers = parseInput(userInput);
                this.ball = new Ball(numbers);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println("다시 입력해 주세요.");
            }
        }
    }

    private List<Integer> parseInput(String userInput) {
        if (userInput.length() != 3) {
            throw new IllegalArgumentException("3자리 숫자를 입력해야 합니다.");
        }

        List<Integer> numbers = new ArrayList<>();
        for (char number : userInput.toCharArray()) {
            if (number >= '1' && number <= '9') {
                numbers.add(number - '0');
            } else {
                throw new IllegalArgumentException("1부터 9사이의 숫자를 입력해야 합니다.");
            }
        }
        return numbers;
    }

    @Override
    public Ball getBall() {
        return this.ball;
    }
}
