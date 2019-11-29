/*
 * @(#)Main.java
 *
 * 1.8
 *
 * 2019/11/29
 *
 * Copyright (c) 2019 Janghee Lee
 * All rights reserved.
 * */

package com.jenny.baseball;

/*
 * 게임이 실행될 메인 클래스
 * Gamable 인터페이스 객체를 생성
 * 반복문으로 게임 재실행 여부를 묻고 재시작 혹은 종료
 */

public class Main {

    public static void main(String[] args) {
        Gamable baseball = new Baseball();

        while(true){
            baseball.run();
            if(baseball.wantRestart() == 2){
                break;
            }
        }
    }
}
