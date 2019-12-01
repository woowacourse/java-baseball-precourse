/*
 * @(#)PlayBaseballGame.java		 2019/12/02
 * 
 * 
 * Copyright (c) YerinCho
 * 
 * 
 */

package playbaseballgame;

import java.util.Scanner;

/**
 * 
 * @version 0.1 2019년 12월 2일
 * @author YerinCho
 */

public class PlayBaseballGame {
	Scanner sc = new Scanner(System.in);
	
	private Computer com = new Computer();
	private Player player = new Player(); 
	
	public void run() { 
		
		System.out.println("숫자 야구 게임 시작!");
		com.makeAnswer();
		int playerans=0;		//플레이어가 입력한 값 저장할 변수
		
		/*플레이어가 맞출 때까지 게임이 진행된다. 맞춰서 아웃이 되면 반복문 탈출*/
		while(true) {
			player.askNumber();
			playerans=player.returnAns();
			
			/*아웃이면 종료 게임 종료*/
			if(com.checkStrikeBall(playerans)==false) {
				break;
			}
		}
		
		isStop();			//게임을 새로 시작할지 판단
		return;
		
	}
}

