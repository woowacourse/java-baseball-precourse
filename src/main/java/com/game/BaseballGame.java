package com.game;

public class BaseballGame {

    public static void main(String[] args) {
    }

    /**
     * result[0] = 스트라이크 값
     * result[1] = 볼 값
     */
    int[] compareNumber(final int[] com, final int[] user) {
        int[] check = new int[10];
        for (int i = 0; i < 3; ++i) {
            check[com[i]] = i + 1;
        }

        int[] result = new int[2];
        for (int i = 0; i < 3; ++i) {
            if (check[user[i]] == (i + 1)) {
                ++result[0];
            } else if (check[user[i]] != 0) {
                ++result[1];
            }
        }

        return result;
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
