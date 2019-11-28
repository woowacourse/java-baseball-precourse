package baseball;

public class Umpire {
	private int strike = 0, ball = 0;
	private int[] ans;
	
	Umpire(int[] ans) {
		this.ans = ans;
	}
	
	boolean result(int str, int bl) {
		return str == 3;
	}
	
	void printHint(int str, int bl) {
		if(str == 3) {
			System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료 ");
			System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. ");
		} else {
			String hint = "";
			if(str > 0) {
				hint += str + " 스트라이크 ";
			}
			if(bl > 0) {
				hint += bl + " 볼 ";
			}
			if(hint.length() == 0) System.out.println("Nothing");
			else System.out.println(hint);
		}
	}
	
	boolean compare(int[] ans, int[] userAns) {
		for(int i=0; i<userAns.length; i++) {
			int idx = isExist(userAns[i]);
			if(idx == i) strike++;
			else if(idx >= 0) ball++;
		}
		printHint(strike, ball);
		return result(strike, ball);
	}
	
	int isExist(int val) {
		for(int j=0; j<ans.length; j++) {
			if(isEqual(val, ans[j])) {
				return j;
			}
		}
		return -1;
	}
	
	boolean isEqual(int v1, int v2) {
		return v1 == v2;
	}
}
