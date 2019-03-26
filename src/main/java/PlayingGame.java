/**
 * 이 클래스는 baseball 게임을 실행하는 클래스이다.
 * start() 메서드를 실행하면 게임이 시작된다.
 * 
 *className PlayingGame
 *version 	1.0.0
 *Date		26/03/2019
 *author	권경동 
 */

import java.util.Scanner;
public class PlayingGame {
	
	private int stCount;
	private int ballCount;
	private RandomNumbers ranNum;
	private InputNumbers inNum;
	
	public void start() {
		gameSet();
		
		do {
			play();
			printCount();			
		} while (stCount != 3);		
		continueCheak();
	}
	
	private void gameSet() {
		ranNum = new RandomNumbers();			
	}
	
	private void play() {
		stCount = 0;
		ballCount = 0;
		
		System.out.print("숫자를 입력해 주세요:");		
		inNum = new InputNumbers();
			
		for(int i = 0; i < 3 ; i ++) {
			for(int j = 0 ; j <3 ; j++) {
				count(i,j);
			}
		}				
	}
	
	private void count(int i , int j) {		
		if(ranNum.num[i] == inNum.num[j]) {
			if(i == j) {
				stCount++;
			} else {
				ballCount++;
			}
		}
	}
	
	private void printCount() {		
		if(stCount == 0 && ballCount == 0) {
			System.out.println("낫싱");
		} else {
			if(stCount != 0) {
				System.out.print(stCount + " 스트라이크");
			}
			if(ballCount != 0) {
				System.out.print(ballCount + " 볼");
			}
			System.out.println();
		}			
		
		if(stCount == 3) {
			System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
		}
	}
	
	private void continueCheak() {
		Scanner sc = new Scanner(System.in);
		int inputNum;
		
		System.out.println("게임을 새로 시작하려면 1,종료하려면 2를 입력하세요.");
		inputNum = sc.nextInt();
		if(inputNum == 1) {
			start();
		} else if(inputNum == 2) {}
	}
	
}
