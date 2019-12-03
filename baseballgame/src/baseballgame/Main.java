package baseballgame;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		int command;
		Scanner sc = new Scanner(System.in);
		BaseballGame game = new BaseballGame();
		System.out.println("====게임을 시작합니다====");
		game.run();
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
		command = sc.nextInt();
		while(!isRestart(command)) {
			System.out.println("====게임을 시작합니다====");
			game.run();
			System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
			command = sc.nextInt();
		}
		
	}
	public static boolean isRestart(int command) {
		if(command == 1) {
			return false;
		}else{
			return true;
		}
	}
}
