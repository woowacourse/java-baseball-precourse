package baseball;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
        StringGameGuide guide = new StringGameGuide();
        int selectGame;
        
        while(true) {
        	System.out.println(guide.startGame());
        	selectGame = scanner.nextInt();
        	switch(selectGame) {
        		case 1:
        			System.out.println(guide.restartGame());
        			break;
        		case 2:
        			System.out.println(guide.gameOver());
        		default:
        			System.out.print(guide.wrongSelect()+"\n");
        	}
        	
        	
        }
    }
}
