package baseball;

public class Round {
	private Computer computer;
	private int cnt_strike;
	private int cnt_ball;
	
	public Round(Computer computer) {
		this.computer= computer;
		this.cnt_strike= 0;
		this.cnt_ball= 0;
	}
	
	public void init() {
		computer.init();
		cnt_strike= 0;
		cnt_ball= 0;
	}
	
	//"숫자 입력하세요"
	//유효성 검사
	//strike, ball검삭
	//결과 출력
	

}
