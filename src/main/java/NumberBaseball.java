/*
 *NumberBaseball.class
 *
 *2019.03.28
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
		userNum=getUserNum();
		
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
	
	
	/*사용자의 세자리 수 입력 메소드*/
	public static int[] getUserNum() {
		int userNum[]=new int[3];
		
		int input = scan.nextInt();
		
		
		/*숫자 중복 되지 않도록 확인*/
		userNum[0]=input/100; //100의 자리
		input-=input/100*100; //100의 자리 날리기
		userNum[1]=input/10; //10의 자리
		userNum[2]=input%10; //1의 자리
		
		return userNum;
	}
}

