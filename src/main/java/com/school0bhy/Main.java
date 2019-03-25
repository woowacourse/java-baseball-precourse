/*
 * Main.java    1.0 20190326
 *
 * Copyright (c) 2019 Hyeonyeong Baek.
 * All rights reserved.
 */
package com.school0bhy;

/**
 * Baseball 객체를 생성하여 숫자야구를 수행하기 위한 메인 클래스
 *
 * @version     1.00
 * @author      백현영
 */
public class Main {

    /**
     * Baseball 객체를 생성하여 숫자야구 게임을 수행
     * @param args
     */
    public static void main(String[] args) {
        Baseball baseball = new Baseball(3, 1, 9);
        do {
            baseball.play();
        } while (checkContinue());
    }

    /**
     * 게임 재시작 여부를 확인
     * @return true, false
     */
    private static boolean checkContinue(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        while (true) {
            int check =UserInput.getIntInput();
            if (check == 1) {
                return true;
            } else if (check == 2) {
                System.out.println("게임을 종료합니다.");
                return false;
            } else {
                System.out.println("1 또는 2를 입력하세요.");
            }
        }
    }
}
