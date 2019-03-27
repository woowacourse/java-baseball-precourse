
public class Computer {
	public int targetnum = 0;
	
	public void create_num() {
		int num1, num2, num3;
		
		while(true) {
			// 임의의 세 숫자를 랜덤함수 를 통해 생성 (1 ~ 9)
			num1 = (int) (Math.random() * 9 + 1);
			num2 = (int) (Math.random() * 9 + 1);
			num3 = (int) (Math.random() * 9 + 1);
			
			// 세 숫자가 중복이 되지 않을 때 까지 반복 후 만족할 경우 루프 탈출
			if ( num1 != num2 && num2 != num3 && num3 != num1) {
				break;
			}
		}
		// 세 숫자를 각 자리수로 하여 타겟넘버 설정
		this.targetnum = (num1 * 100) + (num2 * 10) + num3;
	}
}
