/*
 * MainApp.java        2019/03/24
 *
 * Copyright (c) 2019 Yumin Kim.
 * All rights reserved.
 */

/**
 * MainApp 클래스는 이 프로젝트의 main 메소드를 가지고 있습니다.
 * main 메소드에서 Player, Computer 객체가 상호작용하며 숫자야구게임이 진행됩니다.
 *
 * @version       1.00 2019년 3월 24일
 * @author        김유민
 */
public class MainApp {
    /** 본 프로젝트의 main 메소드입니다. */
    public static void main(String args[]) {
        Computer c = new Computer();
        Player p = new Player();

        while(true) {
            c.askNumbers();
            p.makeGuess();
            int guess[] = p.tellGuess();
            boolean isCorrect = c.checkGuess(guess);
            c.giveHint();
            if (!isCorrect) {
                continue;
            }
            c.askEnd();
            boolean isEnd = p.wantToEnd();
            if (isEnd) {
                break;
            }
        }

    }
}
