import java.util.Scanner;

public class User {
	/*게임 종료시 re or quit을 묻는 함수*/
	public boolean reOrQuit(){
		Scanner in = new Scanner(System.in);
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		int input;
		input = in.nextInt();
		if( input == 2 )	//2를 입력했다면 종료
			return false;
		return true;
	}
}
