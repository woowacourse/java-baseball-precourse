
public class Count {

	public int first_num;
	public int second_num;
	public int third_num;
	public int input_first;
	public int input_second;
	public int input_third;
	
	public int makeNum() {
		return (int)(Math.random()*10) + 1;
	}
	
	public void getFirst() {
		first_num = makeNum();
		while(first_num == 0) {
			first_num = makeNum();
		}
	}
	
	public void getSecond() {
		second_num = makeNum();
		while(second_num == 0 || second_num == first_num) {
			second_num = makeNum();
		}
	}
	
	public void getThird() {
		third_num = makeNum();
		while(third_num == 0 || third_num == first_num ||
				third_num == second_num) {
			third_num = makeNum();
		}
	}
	
	public int getS() {
		int cnt = 0;
		
		if(first_num == input_first) cnt++;
		if(second_num == input_second) cnt++;
		if(third_num == input_third) cnt++;
		
		return cnt;
	}
	
	public int getB() {
		int cnt = 0;
		
		if(first_num == input_second || first_num == input_third) cnt++;
		if(second_num == input_first || second_num == input_third) cnt++;
		if(third_num == input_first || third_num == input_second) cnt++;
		
		return cnt;
	}

}
