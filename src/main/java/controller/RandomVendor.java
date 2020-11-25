package controller;

import utils.RandomUtils;

import java.util.Arrays;

public class RandomVendor {

    private static final int START_NUMBER = 111;
    private static final int END_NUMBER = 999;

    private static boolean[] visited;

    public RandomVendor() {
        this.visited = new boolean['9' + 1];
    }

    public int roll() {

        int num = getNumber();

        while(!checkVaild(num)) {
            num = getNumber();
        }

        return num;
    }

    private int getNumber() {
        return RandomUtils.nextInt(START_NUMBER, END_NUMBER);
    }

    private boolean checkVaild(int num) {

        initVisited();

        while(num != 0) {
            if(visited[num % 10]) {
                return false;
            }
            if(num % 10 == 0) {
                return false;
            }

            visited[num % 10] = true;
            num /= 10;
        }

        return true;
    }

    private void initVisited() {
        Arrays.fill(visited, false);
    }

}
