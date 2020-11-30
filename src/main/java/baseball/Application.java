package baseball;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
    	final Scanner scanner = new Scanner(System.in);
        int flag;
        Game game = new Game();
        
        while(true) {
        	System.out.println("숫자야구 게임을 시작하려면 1, 종료하려면 2를 입력하세요!");
        	flag = scanner.nextInt();
        	
        	if(flag==2) {
        		System.out.println("안녕히가세요!");
        		scanner.close();
        		break;
        	}else{
        		game.startGame();
        	}
        }
    }
}
