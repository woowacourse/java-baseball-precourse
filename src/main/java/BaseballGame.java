/*
 * 숫자 야구 게임을 수행하는 클래스
 *
 * @version 1.0
 *
 * @date 2019.12.02
 * 
 * @author Jung dahee
 */
 
 import java.util.Scanner;

public class BaseballGame {

    String player1 = null;
    String player2 = null;
    Printer printer = new Printer();
    InputVerification input = new InputVerification();

    public BaseballGame() {
    	setGame();
    	play();
    }
}
