import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		Computer cmp = new Computer();
		User user = new User();
		
		boolean re = true;
		while( re ){
			System.out.println("게임시작!!");
			cmp.random();	//난수 3자리 생성
			boolean quit = true;
			while( quit ){
				int input;	//세자리 숫자 입력
				input = in.nextInt();
				int s = cmp.check_s(input);	//스트라이크 수
				int b = cmp.check_b(input);	//볼 수
				quit = cmp.print(s, b);	//비교 후 출력
			}
			re = user.reOrQuit();	//재시작 할지 그만둘지 묻는 함수
		}
	}
}
