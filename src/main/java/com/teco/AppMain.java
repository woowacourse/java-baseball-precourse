package com.teco;

/**
 * 숫자야구 게임이 시작되는 클래스
 *
 * @author 김성훈
 * @version 1.0
 */
public class AppMain {
    public static void main(String[] args) {
        Game game = new Game(
                new UserInterfaceImpl(),
                new RandomNumberGenerator()
        );
        game.play();
    }
}
