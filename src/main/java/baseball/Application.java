package baseball;

import utils.ThreeDigitsUtils;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        int targetNumber = ThreeDigitsUtils.generateBaseballNumber();
        System.out.println(targetNumber);
    }
}
