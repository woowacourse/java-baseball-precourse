import java.util.Scanner;

public class BaseBall {
	
	public static void initBaseball() {
		Scanner scanner = new Scanner(System.in);
		Count countSB = new Count();
		int strike;
		int ball;
		
		countSB.getFirst();
		countSB.getSecond();
		countSB.getThird();
		
		while(true) {
			System.out.print("숫자를 입력해주세요 : ");
			int input = scanner.nextInt();
			
			countSB.input_first = input/100;
			countSB.input_second = (input%100)/10;
			countSB.input_third = input%10;
			
			strike = countSB.getS();
			ball = countSB.getB();
			
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
		Scanner scanner = new Scanner(System.in);
		int flag = 1;
		
		while(flag == 1) {
			initBaseball();
			
			System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
			flag = scanner.nextInt();
		}
		
	}

}
