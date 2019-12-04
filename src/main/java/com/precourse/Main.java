/**
 * Copyright (c) 2019 Seungwan Park,
 * All rights reserved.
 */

package com.precourse;

/**
 * 클래스 이름 : Main.java
 *
 * @author Seungwan Park, github.com/toneyparky
 * @version 1.0
 * <p>
 * 날짜 : 2019.12.2 월요일
 */
public class Main {
    /*
     * Main 클래스에서는 PlayGame 클래스로부터 인스턴스를 받아서 이를 실행한다.
     * 그리고 terminator 메서드의 결과를 이용하여 게임의 재시작, 종료 여부를 결정한다.
     */

    public static void main(final String[] args) {

        while (true) {
            PlayGame play = new PlayGame();
            play.playGame();
            if (!Terminator.terminator()) {
                break;
            }
        }
    }
}
