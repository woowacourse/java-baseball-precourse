
public class Computer {
	
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
	public int count_s(int[] input_num) {
		int s_cnt = 0;
		
		// 입력 숫자와 각 자리를 비교하여 같은 숫자가 있을 경우 스트라이크 카운터를 증가시킨다. 
		for(int i = 0; i < target_num.length; i++) {
			if( target_num[i] == input_num[i]) {
				s_cnt++;
			}
		}
		return s_cnt;
	}
}
