/**
 *NumberBaseball.class
 *
 * @author 최여진
 *
 */
import java.util.Scanner;


public class NumberBaseball {
	public static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		int userNum[] = new int[3];
		int comNum[] = new int[3];
		
		comNum=getComNum();
	}

	
	/*컴퓨터의 랜덤 함수를 불러오는 메소드*/
	public static int[] getComNum() {
		int comNum[]=new int[3];
		
		/*1에서 9까지의 랜덤 정수*/
		comNum[0]=(int)(Math.random()*9+1);
		
		while(true) {
			comNum[1]=(int)(Math.random()*9+1);
			
			/*각 자리의 숫자들이 겹치지 않도록*/
			if(comNum[1]!=comNum[0]) {
				break;
			}
		}
		
		while(true) {
			comNum[2]=(int)(Math.random()*9+1);
			
			if((comNum[2]!=comNum[1])&&comNum[2]!=comNum[0])
				break;
		}
		
		return comNum;
	}
}

