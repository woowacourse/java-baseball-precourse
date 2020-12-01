package baseball;

import ganerator.NumberGenerator;

import java.util.ArrayList;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        NumberGenerator numberGenerator = new NumberGenerator();
        ArrayList<Integer> newNumber = new ArrayList<>(3); //세자리 수
        newNumber = numberGenerator.generatorNewNumber();
        for (Integer i : newNumber) {
            System.out.println(i);
        }
    }
}
