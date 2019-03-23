package com.game;

public class BaseballGame {

    public static void main(String[] args) {
    }

    /**
     * 1~9까지 중복 없이 3개의 숫자을 배열로 반환
     */
    int[] getRandomNum() {
        int[] ele = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int i = 0; i < 9; ++i) {
            final int del = (int) (Math.random() * 10) % 9;

            final int temp = ele[del];
            ele[del] = ele[i];
            ele[i] = temp;
        }
        return new int[]{ele[0], ele[1], ele[2]};
    }
}
