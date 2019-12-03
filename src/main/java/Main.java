/**
 * 클래스 이름      Main
 * 버전 정보        1.0
 * 날짜            2019.12.03
 * 저작권          joi0104
 */

public class Main {
	
	/*메인함수*/
	public static void main(String[] args) {
		GameRound round;
		CheckRestart restart = new CheckRestart();
		boolean again = true;

		while(again){
			round = new GameRound();           //게임라운드 시작
			round.playGame();                  //게임진행
			again = restart.isRestart();       //게임진행여부 묻기
		}
		
		System.out.println("프로그램 종료");
	}
	
}