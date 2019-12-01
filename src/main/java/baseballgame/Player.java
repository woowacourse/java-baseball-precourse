package baseballgame;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Player {
	private static final int BALL_LEN = 3;
	private static final int ZERO = 0;
	private static final int MAX_NUM = 9;
	private static final int MIN_NUM = 0;
	int tempNum;
	String myStringNums;
	List<Integer> myNums = new ArrayList<Integer>(BALL_LEN);
	Scanner sc = new Scanner(System.in);
	
	public void makeMyNums() {
		myNums.clear();
		System.out.print("숫자를 입력해주세요 : ");
		while (true) {
			myStringNums = sc.nextLine();
			if (checkLength() && checkOverlap() && checkRange()) {
				break;
			}
			System.out.print("잘못입력하셨습니다. 0~9까지의 숫자를 3개 입력해주세요 : ");
		}
		for(int i = ZERO; i < BALL_LEN; i++) {
			myNums.add(myStringNums.charAt(i) - '0');
		}
	}
	private boolean checkOverlap() {
		boolean status = true;
		for(int i = 0; i < BALL_LEN; i++) {
			String temp = myStringNums.replaceFirst(String.valueOf(myStringNums.charAt(i)),"");
			if(temp.contains(String.valueOf(myStringNums.charAt(i)))) {
				status = false;
				break;
			}
		}
		return status;
	}
	private boolean checkLength() {
		boolean status = false;
		if(myStringNums.length() == BALL_LEN) {
			status = true;
		}
		return status;
	}
	private boolean checkRange() {
		boolean status = true;
		for(int i = ZERO; i < BALL_LEN; i++) {
			if (myStringNums.charAt(i) - '0' <= MIN_NUM || myStringNums.charAt(i) - '0' > MAX_NUM) {
				status = false;
				break;
			}
		}
		return status;
	}
}