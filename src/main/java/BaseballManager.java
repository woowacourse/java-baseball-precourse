/*
 * 클래스 이름 : BaseballManager
 * 클래스 설명 : 야구게임을 관리하는 클래스이다.
 * 작성자 : Moonyoung Chae
 * 날짜 : 2019/12/01
 * Copyright (c) 2019 Moonyoung Chae
 */

public class BaseballManager {
    private final int NUMBER_SIZE = 3;

    // 필요한 함수를 호출하고 게임을 관리하는 함수
    public void run(){
        createComputerNumber();
    }

    // 컴퓨터 난수를 생성하는 함수
    public void createComputerNumber(){
        int computerNumber = 0;
        for(int i = 0; i < NUMBER_SIZE; i++) {
            computerNumber *= 10;
            computerNumber += (int) (Math.random() * 10);
        }
    }
}
