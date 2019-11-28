package baseball;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Game {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String regExp = "^[1-9]*$";
		
		Computer computer = new Computer();
		int[] answer = computer.createAnswer(); //컴퓨터가 가지고 있는 정
		
		int[] userAns = new int[3];
		
		String input = sc.next();
		while(!input.matches(regExp) || input.length() != 3) {
			System.out.print("3자리 자연수만 입력 가능합니다. ");
			input = sc.next();
		}
		
		StringTokenizer st = new StringTokenizer(input);
		int idx = 0;
		while(st.hasMoreTokens()) {
			userAns[idx++] = Integer.parseInt(st.nextToken());
		}
		
	}
}
