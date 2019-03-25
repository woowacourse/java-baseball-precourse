
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
}
