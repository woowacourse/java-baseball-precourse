package com.github.callmewaggs.javabaseballprecourse;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User {
    private List<Integer> numbers;

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void generateInputBall() {
        Scanner scan = new Scanner(System.in);
        while (true) {
            this.numbers = new ArrayList<>();
            System.out.print("숫자를 입력해주세요 : ");
            String userInput = scan.nextLine();

            if (!isValidate(userInput)) {
                System.out.println("1 ~ 9 까지의 3자리 숫자를 입력해 주세요.");
            } else {
                break;
            }
        }
    }

    private boolean isValidate(String userInput) {
        if (userInput.length() != 3)
            return false;
        for (char c : userInput.toCharArray()) {
            if (c >= '1' && c <= '9') {
                this.numbers.add(c - '0');
            } else
                return false;
        }
        return true;
    }
}
