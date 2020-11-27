package baseball;

import java.util.Scanner;
import utils.RandomUtils;
public class Application {
    public static void main(String[] args) {
    	// TODO 구현 진행
    	final Scanner scanner = new Scanner(System.in);
    	while(true) {
	    	int[] rand_num = random_3Num();	    		    	
	    	while(true) {
	    		System.out.print("숫자를 입력해주세요 : ");
	    		int[] guess = guess_Num(scanner.nextInt());	    		
	    		int[] result = check_Num(rand_num, guess);
	    		
	    		if(result[0]!=0 && result[1]!=0)
	    			System.out.printf("%d볼 %d스트라이크\n",result[0],result[1]);
	    		else if (result[0]==0 && result[1]!=0)
	    			System.out.println(""+result[1]+"볼");
	    		else if (result[0]!=0 && result[1]==0)
	    			System.out.println(""+result[0]+"스트라이크");
	    		else if (result[0]==0&&result[1]==0)
	   				System.out.println("낫싱");
	    		if (result[0]==3) {
	    			System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
	    			break;
	    		}
	    			
	    	}
	    	System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
	    	if (scanner.nextInt() == 2)
	    		break;
    	}
    }
    private static int[] guess_Num(int guess) {
    	if (guess<100 || guess>999)
    		throw new IllegalArgumentException();
    	int[] num = new int[3];
    	for (int i = 2; i >=0; i--) {
			num[i]=guess%10;
			guess/=10;
		}
		return num;    	
    }
    
    private static int[] check_Num(int[] rand_num, int[] guess) {
    	int[] SnB = {0,0};
    	for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (rand_num[i] == guess[j] && i==j)
					SnB[0]++;
				else if (rand_num[i]==guess[j])
					SnB[1]++;
			}
		}
		return SnB;    	
    }
    
    private static int[] random_3Num() {
    	int[] num = new int[3];
    	int[] has_Num = {1,1,1,1,1,1,1,1,1,1,1};
    	for (int i = 0; i < num.length; i++) {
			int r = RandomUtils.nextInt(1, 9);
			if (has_Num[r]==0) 
				i--;
			else {
				num[i]=r;
				has_Num[r] = 0;
			}
		}
    	return num;
    }
}
