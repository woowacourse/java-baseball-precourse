/*
 * Class Name: Baseball
 *
 * Version: 1.0
 *
 * Date: 2019.03.27
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Baseball {
    ArrayList<Integer> computer = new ArrayList<>();
    ArrayList<Integer> user = new ArrayList<>();

    Baseball() {
        this.getRandomNumbers();
    }

    private void getRandomNumbers() {
        Random rand = new Random();

        ArrayList<Integer> numbers = new ArrayList<>();

        for (int i = 1; i < 10; i++) {
            numbers.add(i);
        }

        for (int j=0; j<3; j++) {
            int index;

            index = rand.nextInt(8 - j);
            computer.add(numbers.get(index));
            numbers.remove(index);
        }
    }

    public void getUserInput() {
        int userInput;
        Scanner scan = new Scanner(System.in);

        System.out.print("숫자를 입력해주세요 : ");
        userInput = scan.nextInt();

        this.parseUserInput(userInput);
    }

    private void parseUserInput(int userInput) {
        for (int i = 2; i >= 0; i--) {
            user.add(userInput % 10);
            userInput = userInput / 10;
        }
        Collections.reverse(user);
    }

    public boolean checkResult() {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < 3; i++) {
            if (computer.indexOf(user.get(i)) == i) {
                strike++;
            } else if (computer.indexOf(user.get(i)) != -1) {
                ball++;
            }
        }

        this.printResult(strike, ball);

        if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

            return true;
        } else {
            return false;
        }
    }

    private void printResult(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        }
        if (strike > 0 && ball > 0) {
            System.out.print(strike + " 스트라이크 ");
        } else if (strike > 0) {
            System.out.println(strike + " 스트라이크");
        }
        if (ball > 0) {
            System.out.println(ball + " 볼");
        }
    }
}
