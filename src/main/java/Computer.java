/*
 * Computer.java        2019/03/25
 *
 * Copyright (c) 2019 Yumin Kim.
 * All rights reserved.
 */

/**
 * Computer 클래스는 숫자야구게임에서 플레이어를 상대합니다.
 * 주 역할은 플레이어의 추측을 받아 자신의 정답과 비교하여 힌트를 주는 것입니다.
 *
 * @version       1.00 2019년 3월 25일
 * @author        김유민
 */
public class Computer {
    /** 컴퓨터의 정답이 저장되는 멤버변수입니다. */
    private int answer[];

    /** 컴퓨터 클래스의 생성자입니다. 객체가 생성될 시, 임의의 타당한 값으로 answer 멤버변수를 초기화 해야합니다. */
    public Computer() {
        initAnswer();
    }

    /** 컴퓨터가 숫자를 입력하라는 메세지를 콘솔에 출력하여 플레이어에게 전달합니다. */
    public static void askNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    /** 플레이어의 추측과 자신의 정답을 비교하여 플레이어가 정답을 맞췄는지 아닌지를 알려줍니다. */
    public boolean checkGuess(int[] guess) {
        if (answer.length != guess.length) {
            return false;
        }

        for (int i=0; i<answer.length; i++) {
            if (answer[i] != guess[i]) {
                return false;
            }
        }

        return true;
    }

    /** 플레이어의 추측과 자신의 정답을 비교하여 힌트를 콘솔에 출력하여 플레이어에게 전달합니다. */
    public void giveHint(int[] guess) {
        int nStrike = 0;
        int nBall = 0;

        /* 스트라이크의 개수를 측정합니다. */
        for (int i=0; i<answer.length; i++) {
            if (answer[i] == guess[i]) {
                nStrike++;
            }
        }

        /* 볼의 개수를 측정합니다. */
        for (int i=0; i<answer.length; i++) {
            if (guess[i] == answer[(i+1) % 3] || guess[i] == answer[(i+2) % 3]) {
                nBall++;
            }
        }

        /* 스트라이크가 0개이고, 볼이 0개이면 낫싱입니다. */
        if (nStrike == 0 && nBall == 0) {
            System.out.println("낫싱");
        } else {
            if (nStrike > 0) {
                System.out.print(nStrike + " 스트라이크 ");
            }

            if (nBall > 0) {
                System.out.println(nBall + " 볼");
            } else {
                System.out.println();
            }
        }

    }

    /** 플레이어에게 게임을 끝낼 것인지, 지속할 것인지를 묻는 메세지를 콘솔에 출력하여 플레이어에게 전달합니다. */
    public static void askEnd() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    /** answer 멤버변수의 값을 초기화합니다. */
    public void initAnswer() {
        answer = new int[3];
        int curIndex = 0;
        while (curIndex < answer.length) {
            int intVal = (int)(Math.random() * 9) + 1;  // range: 1 ~ 9
            /* answer 는 정수 배열이므로, 정수 타입의 초깃값인 0으로 초기화되어 있는 상태이기 때문에 어떤 경우에도
               1 이상 9 이하의 정수인 intVal과 동일한 값이 될 수 없습니다. 따라서 무한루프에 빠지지 않습니다.*/
            if (intVal == answer[0] || intVal == answer[1] || intVal == answer[2]) {
                continue;
            }
            answer[curIndex++] = intVal;
        }
    }
}
