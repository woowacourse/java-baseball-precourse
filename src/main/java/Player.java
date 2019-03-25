/*
 * Player.java        2019/03/25
 *
 * Copyright (c) 2019 Yumin Kim.
 * All rights reserved.
 */

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Player 클래스는 숫자야구게임의 유저를 대표합니다.
 * 주 역할은 정답을 알고 있는 컴퓨터를 상대로 숫자를 추측하는 것입니다.
 *
 * @version       1.00 2019년 3월 25일
 * @author        김유민
 */
public class Player {
    /** 플레이어의 추측이 저장되는 멤버변수입니다. */
    private int guess[];

    /** 플레이어가 컴퓨터를 상대로 정답을 추측하는 메소드입니다. 추측한 정답은 guess 멤버변수에 저장됩니다. */
    public void makeGuess() {
        Scanner rd = new Scanner(System.in);
        int intGuess;

        while(true) {
            try {
                intGuess = rd.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("[ERROR] 잘못된 입력입니다. 정수형이 아닌 타입을 입력하실 수 없습니다. 다시 입력해 주십시오.");
                Computer.askNumbers();
                rd.nextLine();  // 입력 버퍼를 비웁니다.
                continue;
            }
            int intArrGuess[] = {intGuess / 100, (intGuess / 10) % 10, intGuess % 10};  // e.g., 432 -> {4, 3, 2}
            boolean isThreeDigits = (intGuess / 1000) == 0 && (intGuess / 100) >= 1;
            boolean isDifferent = intArrGuess[0] != intArrGuess[1] && intArrGuess[0] != intArrGuess[2]
                                                                   && intArrGuess[1] != intArrGuess[2];
            boolean isThereZero = intArrGuess[0] == 0 || intArrGuess[1] == 0 || intArrGuess[2] == 0;
            if (isThreeDigits && isDifferent && !isThereZero) {
                this.guess = intArrGuess;
                break;
            }
            System.out.println("[ERROR] 잘못된 입력입니다. 1 이상 9 이하의 서로 다른 3 개의 수를 입력해주십시오." +
                    " e.g., 729");
            Computer.askNumbers();
        }
    }

    /** 플레이어가 클래스 외부로 자신의 추측을 알려주는 메소드입니다. */
    public int[] tellGuess() {
        return this.guess;
    }

    /** 플레이어가 자신이 게임을 지속하기를 원하는지 아닌지를 알려주는 메소드입니다. */
    public static boolean wantToEnd() {
        Scanner rd = new Scanner(System.in);
        int userInput;

        while(true) {
            try {
                userInput = rd.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("[ERROR] 잘못된 입력입니다. 정수형이 아닌 타입을 입력하실 수 없습니다.");
                Computer.askEnd();
                rd.nextLine();  // 입력 버퍼를 비웁니다.
                continue;
            }
            if (userInput == 1) {
                return false;
            } else if (userInput == 2) {
                return true;
            } else {
                System.out.println("[ERROR] 잘못된 입력입니다. 1 혹은 2 만 입력하실 수 있습니다.");
                Computer.askEnd();
            }
        }
    }
}
