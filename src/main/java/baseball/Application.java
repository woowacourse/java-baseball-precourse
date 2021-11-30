package baseball;


import java.util.HashSet;
import java.util.Set;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
public class Application {
	
	static int ball = 0, strike = 0; 
	

    public static void main(String[] args) {
    	int trigger = 1;
    	while(trigger == 1) {
    		if(trigger == 1) {
        		//새게임
        		gameStart();
        		trigger= result.Reset();
        		
        	}
    		if(trigger ==2) {
        		//제임종료
        		System.out.println("게임 종료");
        	}
//    		else {
//    			throw new IllegalArgumentException("잘못된 입력값 입니다.");
//    		}
    	}
    		
    }
    
    
    //게임 스타트
    static void gameStart() {
    	ball = 0; strike = 0;
    	String n = RandomNumber.threeNum();
    	System.out.println(n);
    
    	//사용자 입력
    	while (strike !=3) {
    		ball=0; strike=0;
	    	String g = GuessNumber.input();
	    	
	    	for(int i = 0; i < 3; i ++) {
	    		countBall(n,g,i);
	    		countStrike(n,g,i);
	    	}
	    	//결과출력하기 
	    	result.output(ball, strike);
    	}	
    	
    }
    
 
    //볼 카운트
    static void countBall(String n ,String g, int idx) {	
    	if(n.charAt(idx)!=g.charAt(idx) && g.contains(Character.toString(n.charAt(idx)))){
    		ball++;
    	}
    }
   
    //스트라이크 카운트
    static void countStrike(String n ,String g, int idx) {	
    	if(n.charAt(idx)==g.charAt(idx)){
    		strike++;
    	}
    }
    
  
}
 



class RandomNumber{
    	//컴퓨터가 3자리 만들기
    	static final int[] n =new int[3];
    	static final int startNum = 1;
    	static final int endNum = 9;
    	static final int cnt = 0;
    	
    	static String threeNum() {
    		 //중복방지용
        	Set<Integer> set = new HashSet<>();
       	
        	while(set.size() <3) {
	    		set.add(Randoms.pickNumberInRange(startNum, endNum));
        	}
        	
        	StringBuilder strB = new StringBuilder();
        	set.forEach(strB::append);
        	//문자열로 리턴
        	return strB.toString(); 
    }
}



class GuessNumber{
	
	static String input() {
	System.out.print("숫자를 입력해주세요 :");
	String read = Console.readLine();
		if(read.length() !=3) {
	        throw new IllegalArgumentException("잘못된 입력값 입니다.");
		}
	return read;
	}
}




class result{
	static void output(int ball, int strike) {
		if(ball != 0 ) {
	    	System.out.print(ball + "볼");
	    	if(strike == 0){
	    		System.out.println();}
		}
		if(strike != 0) {
	    	System.out.println(strike + "스트라이크");  	

		}
		if(ball==0 && strike==0 ) {
	    	System.out.println("낫싱");  	
		}
		if(strike == 3) { 	
	    	System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");  
		}
	}
	static int Reset() {
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		String goStop = Console.readLine();
		return Integer.valueOf(goStop);
	}
}
//깃 테스트
  
