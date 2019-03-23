package com.game;

import java.util.Scanner;

public class BaseballGame {
    public static void main(String[] args) {
        BaseballGame game = new BaseballGame();
        Scanner scan = new Scanner(System.in);

        do {
            final int[] comNum = game.getRandomNum();
            int[] result;

            if (false) {
                System.out.println(comNum[0] + "" + comNum[1] + "" + comNum[2]);
            }

            do {
                final int[] userNum = game.getUserNum(scan);
                result = game.compareNumber(comNum, userNum);

                game.resultPrint(result);
            } while (result[0] != 3);

            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            int what = scan.nextInt();
            if (what == 2) {
                break;
            }
            scan.nextLine(); // 개행문자 제거

        } while (true);
    }

    /**
     * 결과를 출력하는 함수
     */
    void resultPrint(final int[] result) {
        if (0 < result[0]) {
            System.out.print(result[0] + " 스트라이크 ");
        }
        if (0 < result[1]) {
            System.out.print(result[1] + " 볼");
        }
        if ((result[0] == 0) && (result[1] == 0)) {
            System.out.print("포볼");
        }
        System.out.println();
    }

    /**
     * 유저가 입력한 문자열을 integer 배열로 반환
     **/
    int[] getUserNum(Scanner scan) {
        int[] ret = new int[3];

        while (true) {
            System.out.print("숫자를 입력해주세요: ");
            String in = scan.nextLine();

            if (in.length() != 3) {
                System.out.println("옳바르게 입력하세요.");
                continue;
            }
            if (!isInteger(in.charAt(0)) ||
                    !isInteger(in.charAt(1)) || !isInteger(in.charAt(2))) {
                System.out.println("옳바르게 입력하세요.");
                continue;
            }

            ret[0] = in.charAt(0) - '0';
            ret[1] = in.charAt(1) - '0';
            ret[2] = in.charAt(2) - '0';
            break;
        }

        return ret;
    }

    /**
     * 매개변수 c가 1~9 정수로 변경될 수 있는지 판단 하는 함수
     */
    boolean isInteger(final char c) {
        return ('1' <= c && c <= '9') ? true : false;
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
