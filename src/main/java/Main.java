/*
 * 클래스 이름 : Main
 * 클래스 설명 : 야구 게임을 실행하는 클래스이다.
 * 작성자 : Moonyoung Chae
 * 날짜 : 2019/12/01
 * Copyright (c) 2019 Moonyoung Chae
 */

public class Main {
    public static void main(String[] args) {
        // 게임이 구현된 baseball 함수 호출
        BaseballManager baseballManager = new BaseballManager();
        baseballManager.createComputerNumber();
        System.out.println(baseballManager.computerNumber.getNumber());

    }
}
