
public class Computer {
	int s_cnt = 0; // strike count;
	int b_cnt = 0; // ball count;
	Baseball bs = new Baseball();
	public int[] target_num = new int[3];
	
	public void create_num() {
		
		while(true) {
			// 임의의 세 숫자를 랜덤함수 를 통해 생성 (1 ~ 9)
			for(int i = 0; i < target_num.length; i++) {
				target_num[i] = (int) (Math.random() * 9 + 1);
			}
			
			// 세 숫자가 중복이 되지 않을 때 까지 반복 후 만족할 경우 루프 탈출
			if ( target_num[0] != target_num[1] && target_num[1] != target_num[2] 
					&& target_num[2] != target_num[1]) {
				break;
			}
		}
	}
	
	// 타겟 넘버를 받아 스트라이크 횟수를 카운트 합니다. 
	public void count_s(int[] input_num) {
		// 입력 숫자와 각 자리를 비교하여 같은 숫자가 있을 경우 스트라이크 카운터를 증가시킨다. 
		for(int i = 0; i < target_num.length; i++) {
			if( target_num[i] == input_num[i]) {
				this.s_cnt++;
			}
		}
	}
	// 입력 숫자를 한자리 씩을 타겟넘버 전체를 순환하며 한자리 씩 비교하고 같을 경우 볼 카운터를 증가시킨다.
	public void count_b(int[] input_num) {
		
		for (int i = 0; i < target_num.length; i++) {
			for ( int j = 0; j < input_num.length; j++) {
				if(target_num[i] == input_num[j]) {
					b_cnt++;
				}
			}
		}
		// 전체 순환하는 과정에서 스트라이크 개수 또한 볼 카운트 조건에 해당하므로 스트라이크 개수를 차감함
		this.b_cnt -= this.s_cnt;
	}
	
	public void result() {
		// 스트라이크와 볼 모두 없는 경우
		if (s_cnt == 0 && b_cnt == 0) {
			System.out.println("낫싱");
		}
		else {
			System.out.println(s_cnt + "스트라이크" + b_cnt + "볼");
			if(s_cnt == 3) {
				System.out.println("정답! 숫자를 모두 맞히셨습니다. 게임 끝");
				bs.gameMenu();
			}
		}
		
	}
}
