package src.main.java;

import java.util.Scanner;

/**
 * 프로그램을 시작하는 main
 * 재시작 및 종료
 * @author 강연욱
 *
 */
public class Main {

    /**
     * 게임 종료 시, 재시작 or 완전 종료
     * game이 종료 된 후 동작하는 method로 main에서 이용할 수 있도록 구현
     * @return
     */
    public static boolean replay() {
        
    	int input;
        
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
		
        Scanner sc = new Scanner(System.in);
        input = sc.nextInt();
		
        return input == 2;
    }
    
    public static void main(String[] args) {
		
        while (true) {
            Baseball bb = new Baseball();
            bb.game();
			
            if (replay()) {
                break;
            }
        }
        
        System.out.println("게임을 종료합니다.");
    }
}
