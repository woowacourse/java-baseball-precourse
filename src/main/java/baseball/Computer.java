package baseball;

import java.util.Random;

public class Computer {
	private int[] answer = new int[3];
	private boolean[] selection = new boolean[9]; //중복된 숫자가 선택되지 않도록 관리하는 boolean 배열 
	
	public int[] createAnswer() {
		clearSelection(); //새로운 정답을 얻기 전에 이전의 selection 결과 초기화 
		for(int i=0; i<answer.length; i++) {
			answer[i] = makeRandom();
			while(selection[answer[i]-1]) {
				answer[i] = makeRandom();
			}
			selection[answer[i]-1] = true;
		}
		return answer;
	}
	
	void clearSelection() {
		for(int i=0; i<selection.length; i++) {
			selection[i] = false;
		}
	}
	
	int makeRandom() {
		Random rand = new Random();
		return rand.nextInt(9) + 1;
	}
}
