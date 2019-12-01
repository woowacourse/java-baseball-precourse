
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
 * @version 0.1 2019년 12월 2일
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
			tmpnum=sc.next();
			
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
	}
	
	/*플레이어가 입력한 값이 올바른지 판단하는 함수, true 리턴 : 올바름, false 리턴 : 올바르지 않음*/
	public boolean checkInput(String input) {
		boolean check=true;
		
		/*플레이어가 입력한 값이 세자리인지 확인하는 조건문*/
		if(checkLen(input)) {
			check = false;		//세자리가 아닌경우 check에 false값 넣음.
		}
		
		/*플레이어가 입력한 값이 숫자 세개로 되어있는지 확인하는 조건문*/
		if(check && checkStr(input)) {
			check = false;
		}
		
		/*플레이어가 입력한 값이 서로 다른지 확인하는 조건*/
		if(check && checkSame(input)) {
			check = false;
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
}