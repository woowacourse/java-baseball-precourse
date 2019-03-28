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
		
		boolean vaild_num = true; // 판별 여부 함수
		int one = input_num / 100; // 100의자리
		int two = (input_num / 10) % 10; // 10의 자리
		int three = input_num % 10;	 //1의 자리
		// 숫자가 3자리 인지 검증
		if (input_num > 99 && input_num < 1000 ) {
			System.out.println("입력값이 3자리 수가 아닙니다. 입력값을 확인해주세요");
			vaild_num = false;
		}
		// 서로 다른 숫자인지 검증
		if (one == two && two == three && three == one) {
			System.out.println("중복 되는 숫자가 입력되었습니다. 입력값을 확인해주세요");
			vaild_num = false;
		}
		// 숫자가 0 이 포함되어 있는지 검증
		if (one == 0 && two == 0 && three == 0) {
			System.out.println("입력 값에 0이 포함 되어 있습니다. 입력값을 확인해주세요");
			vaild_num = false;
		}
		return vaild_num;
	}
}
