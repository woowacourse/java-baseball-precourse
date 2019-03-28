import java.util.Scanner;

public class Player {
	public int[] Player_num = new int[3];
	
	public int[] input_num() {
		while(true) {
			int input_num = 0;
			Scanner sc = new Scanner(System.in);
		
			input_num = sc.nextInt();
			// 입력 한 값이 참이면 게임을 진행 거짓이면 사용자에게 재입력을 요구한다.
			if(input_vaild(input_num) == true) {
			// 파라메터로 사용하기위해 각 자리 수 별로 배열에 저장
				Player_num[0] = input_num / 100;
				Player_num[1] = (input_num / 10) % 10;
				Player_num[2] = input_num % 10;	
				return Player_num;
			}
			else {
				System.out.println("새로운 숫자를 입력해주세요");
			}
		}
		
	}
	
	
	
	public boolean input_vaild(int input_num) {
		
		return true;
	}
}
