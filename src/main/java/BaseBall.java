import java.util.Scanner;

public class BaseBall {
	
	public static void initBaseball() {
		Scanner scanner = new Scanner(System.in);
		int first_num; 
		int second_num;
		int third_num;
		
		first_num = (int)(Math.random()*9) + 1;
		second_num = (int)(Math.random()*9) + 1;
		third_num = (int)(Math.random()*9) + 1;
		
		while(true) {
			int strike = 0;
			int ball = 0;
			int input_first;
			int input_second;
			int input_third;
			
			System.out.print("숫자를 입력해주세요 : ");
			int input = scanner.nextInt();
			
			input_first = input/100;
			input_second = (input%100)/10;
			input_third = input%10;
			
			if(first_num == input_first) {
				strike++;
			}
			else if(first_num == input_second || first_num == input_third) {
				ball++;
			}
			
			if(second_num == input_second) {
				strike++;
			}
			else if(second_num == input_first || second_num == input_third) {
				ball++;
			}
			
			if(third_num == input_third) {
				strike++;
			}
			else if(third_num == input_first || third_num == input_second) {
				ball++;
			}
			
			if(strike != 0) {
				System.out.print(strike + " 스트라이크 ");
			}
			
			if(ball != 0) {
				System.out.print(ball + " 볼 ");
			}
			
			if(strike == 0 && ball == 0) {
				System.out.print("낫싱");
			}
			System.out.println();
			
			if(strike == 3) {
				System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
				break;
			}
		}
	}

	public static void main(String[] args) {
		initBaseball();
	}

}
