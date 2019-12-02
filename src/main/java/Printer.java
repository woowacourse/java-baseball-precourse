/*
 * 플레이어에게 메세지와 힌트를 주기 위한 클래스 
 *
 * @version 1.0
 *
 * @date 2019.12.02
 * 
 * @author Jung dahee
 */

public class Printer {
	
    String s = null;
	
    /*
     * 게임 시작 및 종료 메세지와 잘못된 데이터에 대한 오류 메시지를 출력하는 메소드
     */
    public void printMessage(int signal) {
	if(signal == 0) {
	    s = "숫자를 입력해주세요 : ";
	} else if(signal == 1) {
	    s = "입력 값이 조건과 맞지 않습니다. 다시 입력해주세요!\n";
	} else if(signal == 2) {
	    s = "입력 값이 없습니다. 다시 입력해주세요!\n";
	} else if(signal == 3) {
	    s = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n";
	}
		
	System.out.print(s);
    }
	
    /*
     * 입력한 숫자에 대한 힌트를 출력하는 메소드
     */
    public void printResult(int strikeCnt, int ballCnt) {
	if(strikeCnt == 3) {
	    s = strikeCnt + " 스트라이크 " + '\n';
	    s += "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
	} else if(strikeCnt == 0 && ballCnt == 0) {
	    s = "낫싱";
	} else if(strikeCnt == 0){
	    s = ballCnt + " 볼 ";
	} else if(strikeCnt - ballCnt == 0) {
	    s = strikeCnt + " 스트라이크 ";
	} else {
	    s = strikeCnt + " 스트라이크 " + Math.abs(strikeCnt - ballCnt) + " 볼 ";
	}
		
	System.out.println(s);
    }
}
