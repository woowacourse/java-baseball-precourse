
/*
 * @(#)Player.java		 2019/12/02
 * 
 * 
 * Copyright (c) YerinCho
 * 
 * 
 */

package playbaseballgame;

import java.util.Scanner;

/**
 * 
 * @version 0.4 2019년 12월 2일
 * @author YerinCho
 */

public class Player {
	private int num = 0;
	
	/*플레이어에게 수 입력 요청하는 함수*/
	public void askNumber() {
		Scanner sc =new Scanner(System.in);
		String tmpnum ="";		//사용자가 입력하는 값이 문자일 수도 있으므로, 스트링으로 tmpnum 선언
		
		while(true) {
			System.out.print("1부터 9까지의 서로 다른 세자리 숫자를 입력해주세요 : ");
			tmpnum=sc.nextLine();
			
			/*플레이어가 입력한 값 사이에 공백이 있는 경우, 공백 제거하는 함수 호출*/
			tmpnum=checkBlank(tmpnum);
			
			/*플레이어가 입력한 값이 올바른지 처리하는 함수*/
			if(checkInput(tmpnum)) {
				break;
			}
			else {
				System.out.println("입력한 값이 올바르지 않습니다.");
			}
		}
		/*문자였던 값을 정수로 변환*/
		this.num=Integer.parseInt(tmpnum);
		sc.close();
	}
	
	
	/*플레이어가 입력한 값의 공백을 제거하는 함수*/
	public String checkBlank(String input) {
		String tmp="";
		
		/*입력값을 살펴보면서, 공백이 아닌 값만 tmp에 추가*/
		for(int i=0;i<input.length();i++) {
			if(input.charAt(i)!=' ') {
				tmp=tmp+input.charAt(i);
			}
		}
		return tmp;
	}
	
	/*플레이어가 입력한 값이 올바른지 판단하는 함수, true 리턴 : 올바름, false 리턴 : 올바르지 않음*/
	public boolean checkInput(String input) {
		boolean check=true;
		
		/*플레이어가 입력한 값이 세자리인지 확인하는 조건문*/
		if(checkLen(input)==false) {
			check = false;		//세자리가 아닌경우 check에 false값 넣음.
		}
		
		/*
		 *입력한 값의 길이가 3이 아닌 경우, 다른 확인 조건을 볼 필요가 없으므로 
		 *check 변수의 값을 먼저 확인 한 후에 다른 조건을 확인한다.
		 *이후 조건들도 마찬가지이다. 
		 * */
		
		/*플레이어가 입력한 값이 숫자 세개로 되어있는지 확인하는 조건문*/
		if(check) {
			if(checkStr(input)==false) {
				check = false;
			}
		}
		
		/*플레이어가 입력한 값이 서로 다른지 확인하는 조건문*/
		if(check) {
			if(checkSame(input)==false) {
				check = false;
			}
		}
		
		/*플레이어가 입력한 값에 0이 있는지 확인하는 조건문*/
		if(check) { 
			if (checkZero(input)==false) {
				check = false;
			}
		}
		
		return check;
	}
	
	/*플레이어가 입력한 값이 세자리인지 확인하는 함수*/
	public boolean checkLen(String input) {
		boolean len=false;
		
		if (input.length()==3) {
			len= true;
		}
		return len;
	}
	
	/*플레이어가 입력한 값이 문자가 아닌 숫자 세개로 되어있는지 확인하는 함수*/
	public boolean checkStr(String input) {
		boolean str=false;
		
		/*입력받은 문자열이 정수로 변환되는지 확인하는 조건문*/
		if(isStringDouble(input)) {	
			str=true;
		}
		
		return str;
	}
	
	/*입력받은 문자열이 정수면 true, 아니면 false 반환*/
	public static boolean isStringDouble(String s) {
	    try {
	        Double.parseDouble(s);
	        return true;
	    } catch (NumberFormatException e) {
	        return false;
	    }
	}
	
	
	/*플레이어가 입력한 수가 서로 다른지 확인하는 함수*/
	public boolean checkSame(String input) {
		boolean same=true;
		
		if(input.charAt(0)==input.charAt(1)) {
			same=false;
		}
		
		if(input.charAt(0)==input.charAt(2)) {
			same=false;
		}
		
		if(input.charAt(1)==input.charAt(2)) {
			same=false;
		}
		
		return same;
	}
	
	/*플레이어가 입력한 수에 0이 있는지 확인하는 함수*/
	public boolean checkZero(String input) {
		boolean zero=true;
		
		if(input.charAt(0)=='0') {
			zero=false;
		}
		
		if(input.charAt(1)=='0') {
			zero=false;
		}
		
		if(input.charAt(2)=='0') {
			zero=false;
		}
		
		return zero;
	}
	
	
	/*플레이어가 입력한 값을 리턴하는 함수*/
	public int returnAns() {
		return num;
	}
	
}