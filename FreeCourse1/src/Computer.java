
public class Computer {
	private int answer=0;	//세자리 랜덤수
	
	/*컴퓨터가 랜덤한 세자리 숫자 구하는 함수*/
	public void random(){
		int n1, n2, n3;
		
		while( true ){			
			//1부터 9까지의수
			n1 = (int) (Math.random() * 9 + 1);
			n2 = (int) (Math.random() * 9 + 1);
			n3 = (int) (Math.random() * 9 + 1);
			
			//각 자리 수가 서로 다른지 확인. 같은 숫자가 있다면 n1~n3 재설정
			if( n1!=n2 && n2!=n3 && n3!=n1 )
				break;
		}
		//answer = n1을 100의자리, n2를 10의자리, n3을 1의자리로 초기화
		this.answer =  (n1 * 100) + (n2 * 10) + n3 ;
	}
	
	/*스트라이크 개수 반환*/
	public int check_s(int input){
		int cnt=0;
		int temp = this.answer;
		 
		for(int i=0; i<3; ++i){
			if(temp % 10 == input % 10)	//자릿수와 숫자까지 같으면 cnt 1증가
				cnt++;
			temp /= 10;
			input /= 10;
		}
		return cnt;
	}
	
	/*볼 개수 반환*/
	public int check_b(int input){
		int cnt=0;
		int temp = this.answer;
		
		// in, ans 배열에 input과 answer의 자릿수 저장
		int in [] = new int[3];
		int ans [] = new int[3];
		for(int i=0; i<3; ++i){
			in[i] = input % 10;
			ans[i] = temp % 10;
			input /= 10;
			temp /= 10;
		}
		//같은 수가 존재하면서 자릿수가 다르면 cnt 1개 추가
		if(in[0]==ans[1] || in[0]==ans[2])
			cnt++;
		if(in[1]==ans[0] || in[1]==ans[2])
			cnt++;
		if(in[2]==ans[0] || in[2]==ans[1])
			cnt++;
		
		return cnt;
	}
}
