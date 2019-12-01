/*
 * Number Baseball
 * 
 * ver 1.0.0
 * 
 * November, 28th, 2019
 * 
 * Copyright(c) Hwangbo Kyeong 2019
 */

import java.util.*;

public class NumberBaseball {

	public static void main(String[] args) {
		int flag = 0;
		Scanner sc = new Scanner(System.in);
		Game game = new Game();

		game.gameStart(); // 첫 게임 시작

		while(true) { // 첫 게임이 종료된 후
			System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
			flag = sc.nextInt();
			if(flag == 1) {
				game.gameStart();
			}
			else if(flag == 2) {
				break;
			}
		}
	}	
}
