package baseball;

import java.util.Scanner;
import java.util.Random;

public class Baseball {
	public static void main(String[] args){
		while(true) {
			Scanner scan = new Scanner(System.in);
			int[] ans = generateThreeRandNum();
			boolean isEqual = false;
			while(!isEqual) {
				System.out.print("숫자를 입력해주세요 : ");
				
				String str = scan.nextLine();
				
				str = check(str);
				
				int[] input = stringToIntArray(str);
				isEqual = compareAndPrintResult(ans,input);
			}
			System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
			System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
			int replay = scan.nextInt();
			scan.nextLine();//nextInt()는 마지막의 개행문자 때문에 다음 입력에 영향을 줌.
			if(replay == 2) {
				break;
			}
			
		}
	}
	
	
	
	static int[] generateThreeRandNum() {
		int ans[] = new int[3];
		Random random = new Random();
		int count = 0;
		while(count < 3) {
			int randomNum = random.nextInt(9)+1;
			if(duplicateCheck(ans, randomNum, count)) {
				continue;
			}else {
				ans[count] = randomNum;
				count++;
			}
		}		
		return ans;
	}
	
	static boolean duplicateCheck(int[] arr, int num, int count) {
		for(int i = 0; i<count; i++) {
			if(arr[i] == num) {
				return true;
			}
		}
		return false;	
	}
	
	static String check(String str) {
		Scanner scan = new Scanner(System.in);
		if(str.length() == 3) {
			if(str.charAt(0)-'0' >= 1 && str.charAt(0) - '0' <= 9
					&&str.charAt(1)-'0' >= 1 && str.charAt(1) - '0' <= 9
					&&str.charAt(2)-'0' >= 1 && str.charAt(2) - '0' <= 9) {
				return str;
			}
		}
		System.out.print("잘못된 숫자를 입력하셨습니다. 다시 입력해주세요 : ");
		String anotherStr = scan.nextLine();
		return check(anotherStr);
	}
	
	static int[] stringToIntArray(String str) {
		int ans[] = new int[3];
		for(int i = 0; i<3; i++) {
			ans[i] = str.charAt(i) - '0';
		}
		return ans;
	}
	
	static boolean compareAndPrintResult(int[] arr1, int[] arr2) {
		int strikeCount = 0;
		int ballCount = 0;
		if(arr2[0] == arr1[0]) {
			strikeCount++;
		}
		if(arr2[0] == arr1[1]) {
			ballCount++;
		}
		if(arr2[0] == arr1[2]) {
			ballCount++;
		}
		if(arr2[1] == arr1[0]) {
			ballCount++;
		}
		if(arr2[1] == arr1[1]) {
			strikeCount++;
		}
		if(arr2[1] == arr1[2]) {
			ballCount++;
		}
		if(arr2[2] == arr1[0]) {
			ballCount++;
		}
		if(arr2[2] == arr1[1]) {
			ballCount++;
		}
		if(arr2[2] == arr1[2]) {
			strikeCount++;
		}
		
		if(strikeCount != 0) {
			System.out.print(strikeCount+"스트라이크 ");
		}
		if(ballCount != 0) {
			System.out.print(ballCount+"볼");
		}
		if(strikeCount == 0 && ballCount == 0) {
			System.out.print("0스트라이크 0볼");
		}
		System.out.println();
		
		if(strikeCount == 3) {
			return true;
		}else {
			return false;
		}
	}

}
