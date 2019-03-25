import java.util.*;

public class baseball {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean answer = true;
		while(answer) {
			answer = playGame();
		}
		System.out.println("게임을 종료합니다.");
	}
	
	public static boolean playGame() {
		System.out.println("숫자를 입력해주세요 : ");
		
		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		
		Scanner sc = new Scanner(System.in);
		int ansInt = sc.nextInt();
		boolean answer = ansInt == 2 ? false : true;
		
		return answer;
	}

}
