import java.util.Scanner;
import java.util.InputMismatchException;
public class Baseball {
	
	
	public void gameMenu() {
		System.out.println("Play!! Baseball");
		System.out.println("게임을 하려면 1, 그만하려면 2를 입력하세요!");
		Scanner sc = new Scanner(System.in);
		int gameinput = 0;
			
		try {
		   gameinput = sc.nextInt();
		   switch(gameinput) {
			  case 1:
				System.out.println("게임시작");
				break;
			  case 2: 
				System.out.println("게임종료");
				break;	
			  default: // 1, 2 외의 숫자가 들어올 경우 재시작
				System.out.println("입력된 값이 잘못되었습니다. 재입력해주세요");
				gameMenu();
				break;
			    }
			}
			// 숫자가 아닌값 들어오면 재시작
			catch (InputMismatchException e) {
	            System.out.println("입력된 값이 잘못되었습니다. 재입력해주세요");
	            gameMenu();
	        }
}
	
	public static void main(String[] args) {
		
		Baseball bs = new Baseball();
		bs.gameMenu();
		
	}
}
