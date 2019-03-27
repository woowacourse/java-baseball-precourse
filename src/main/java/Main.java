/*
 * 클래스 이름: Main.java
 * 버전 정보: 1.0.0
 * 날짜: 2019/03/27
 * Copyright 2018 Inkwon Lee
 */

import java.io.IOException;

/*
 * 메인 함수만 구현
 * 플레이 게임 함수를 불러온다.
*/
public class Main {

    public static void main(String[] args) {
        PlayGame playGame = new PlayGame();
        try {
            playGame.startGame();
        } catch (IOException e) {
            // BufferedReader 에서 파일 읽어올때 생기는 예외 처리 IOException 예외 처리문
            System.out.println(ErrorMessage.IOEXCEPTION_ERROR.getErrorMessage());
        }
    }
}
