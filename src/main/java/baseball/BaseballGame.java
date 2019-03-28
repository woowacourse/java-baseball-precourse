package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

public class BaseballGame {
	/**
	 * 컴퓨터가 선택한 '1부터 9까지 서로 다른 수로 이루어진 3자리의 수'를 리스트에 담는 함수
	 * 
	 * @return 	: '1부터 9까지 서로 다른 수로 이루어진 3자리의 수'로 이루어진 리스트 반환.
	 */
	public List<Integer> question() {
		List<Integer> questionNums = new ArrayList<Integer>();
		
		for (int i=0; i<3; i++) {
			/* 
			 * 다른 자리의 수와 '중복되지 않는 1~9사이의 수'를 추출 - 함수: noOverlap
			 * 수를 '리스트에 할당'
			 */
			int num = noOverlap(questionNums);
			questionNums.add(num);
			System.out.print(num+","); /* 확인용 출력  */
		}
		System.out.println(); /* 확인용 출력  */
		return questionNums;
	}
	
	/**
	 * 다른 자리의 수와 '중복되지 않는 1~9사이의 수'를 추출하는 함수 (1개의 숫자)
	 * 
	 * @param	: 컴퓨터가 선택한 수가 담긴 리스트. 중복되는 값이 있는지 확인 할 때 사용됨. 
	 * @return 	: 중복되지 않는 1~9사이의 수
	 */
	public int noOverlap(List<Integer> questionNums) {
		Random rd = new Random();
		int num = 0;
		
		while (true) {
			num = rd.nextInt(9)+1;

			/* 랜덤값이 리스트에 포함(기존의 수와 중복)되지 않으면  while문 종료.*/
			if (!questionNums.contains(num)) {
				break;
			}
		}
		return num;
	}
	
	/**
	 * 유저가 입력한 '1부터 9까지 서로 다른 수로 이루어진 3자리의 수'를 리스트에 담는 함수 
	 * 
	 * @return 	: '1부터 9까지 서로 다른 수로 이루어진 3자리의 수'로 이루어진 리스트
	 */
	public List<Integer> user() {
		List<Integer> userNums = new ArrayList<Integer>();
		/* '1부터 9까지 서로 다른 수로 이루어진 3자리의 수'를 할당 - 함수: getValidNum */
		String nums = getValidNum();
		
		/* 리스트에 각 자리수 추가 */
		for (int i=0; i<nums.length(); i++) {
			int num = nums.charAt(i)-48;
			userNums.add(num);
			System.out.print(num+","); /* 확인용 출력  */
		}
		System.out.println(); /* 확인용 출력  */
		return userNums;
	}
	
	/**
	 * 유저가 입력한 수가 '1부터 9까지 서로 다른 수로 이루어진 3자리의 수'인지 유효성 검사하는 함수
	 * '1~9까지의 수로 이루어진 3자리의 수'인지 확인하는 함수(checkPattern)와 
	 * '중복여부 확인' 하는 함수(checkOverlap)를 호출하여 
	 * 최종적인 유효성 검사를 함.
	 * 
	 * @return 	: 유저가 입력한 수가 유효하면 true, 아니면 false를 반환.
	 */
	public String getValidNum() {
		Scanner sc = new Scanner(System.in);
		String nums = "";

		/*
		 * 유저가 입력한 수가 유효할 때까지 입력을 반복.
		 * 유저가 입력한 수가 '1~9까지의 수로 이루어진 3자리의 수'이고, '각 자리 수가 중복 되지 않을 때' while문 종료.
		 */
		do {
			System.out.print("숫자를 입력해주세요 : ");
			nums = sc.nextLine();
		} while (!checkPattern(nums) || !checkOverlap(nums));
		
		return nums;
	}
	
	/**
	 * 유저가 입력한 수가 '1~9까지의 수로 이루어진 3자리의 수'인지 확인하는 함수
	 * 
	 * @param	: 유저가 입력한 수(3자리). 유효성 검사 시 사용됨.
	 * @return 	: 유저가 입력한 수가 '1~9까지의 수로 이루어진 3자리의 수'이면 true, 아니면 false를 반환.
	 */
	public boolean checkPattern(String nums) {
		String numberPattern = "^([1-9]{3})$";
		
		if (Pattern.matches(numberPattern, nums)) {
			return true;
		}
		System.out.println("1부터 9사이의 숫자 3개만 입력 가능합니다.");
		return false;
	} 
	
	/**
	 * 유저가 입력한 수에 중복이 있는지 확인하는 함수
	 * 
	 * @param	: 유저가 입력한 수(3자리). 유효성 검사 시 사용됨.
	 * @return 	: 유저가 입력한 수에 '중복'이 없으면 true, 있으면 false를 반환.
	 */
	public boolean checkOverlap (String nums) {
		String[] str_nums = nums.split("");
		String str = "";
		
		/* 
		 * 사용자 입력수의 크기 만큼 반복.(3자리수)
		 * str에 중복되는 값이 있을 시 false를 리턴, 없을 시 str에 해당 수를 추가. 
		 */
		for (int i=0; i<str_nums.length; i++) {
			if (str.contains(str_nums[i])) {
				System.out.println("각 자리의 수는 중복되지 않아야 합니다.");
				return false;
			}
			str += str_nums[i];
		}
		return true;
	}
	
	/**
	 * 게임을 실행하는 함수.
	 * 유저가 컴퓨터가 선택한 값을 맞출 때까지 반복, 
	 * 성공했다면 '게임 진행 여부'를 리턴.
	 *  
	 * @param	: 컴퓨터가 선택한 수. 유저가 입력한 수와 비교할 때 사용됨.
	 * @return 	: 게임의 결과를 담은 배열. (스트라이크 : result[0], 볼 : result[1])
	 */
	public int startGame() {
		/* 컴퓨터가 선택한 수  - 함수: question  */
		List<Integer> questionNums = question();
		int moreGame = 0;
		boolean isSuccess = false; 
		
		/* 유저가 컴퓨터가 선택한 값을 맞출 때까지 반복 - 함수: compareNums */
		while (!isSuccess) {
			int[] result = compareNums(questionNums);
			isSuccess = printResult(result);
		}
		/* '게임을 계속 할 지에 대한 입력'을 저장 - 함수: moreGame */
		moreGame = moreGame();

		return moreGame; 
	}
	
	/**
	 * 컴퓨터가 선택한 수와 유저가 입력한 수를 비교하는 함수.
	 * 
	 * @param	: 컴퓨터가 선택한 수. 유저가 입력한 수와 비교할 때 사용됨.
	 * @return 	: 게임의 결과를 담은 배열. (스트라이크 : result[0], 볼 : result[1])
	 */
	public int[] compareNums(List<Integer> questionNums) {
		/* 유저가 입력한 수  - 함수: user  */
		List<Integer> userNums = user();
		int[] result = new int[2];
		
		/* 
		 * 컴퓨터가 선택한 수와 유저가 입력한 수를 비교 후 
		 * 같은 수가 같은 자리에 있으면 '스트라이크 수 + 1',
		 * 같은 수가 다른 자리에 있으면 '볼 + 1'
		 */
		for (int i=0; i<questionNums.size(); i++) {
			if (userNums.get(i)==questionNums.get(i)) { 
				result[0]++;
			}else if (questionNums.contains(userNums.get(i))) { 
				result[1]++;
			}
		}
		return result;
	}
	
	/**
	 * 게임의 결과를 출력하고 3개의 숫자를 모두 맞혔는 지 확인하는 함수
	 * 
	 * @param	: 스트라이크와 볼의 개수가 담긴 배열. (스트라이크 : result[0], 볼 : result[1])
	 * @return 	: 3개의 숫자를 모두 맞혔으면 true, 아니면 false를 반환
	 */
	public boolean printResult(int[] result) {
		String str = "";
		boolean isSuccess = false;
		
		if(result[0]!=0) { 
			str += result[0]+"스트라이크 ";
		}
		if(result[1]!=0) { 
			str += result[1]+"볼 ";
		}
		if(str.equals("")) { 
			str += "낫싱";
		}
		
		if (result[0]==3) { 
			isSuccess = true;
			str += "\n"+"3개의 숫자를 모두 맞히셨습니다! 게임 종료";
		}
		System.out.println(str);

		return isSuccess;
	}
	
	/**
	 * 게임 진행 여부를 리턴하는 함수.
	 * 유저가 입력한 수가 1 또는 2가 맞는 지 유효성 검사(checkPattern2),
	 * 유효한 입력이 나올 때까지 반복 후  값 리턴.
	 * 
	 * @return 	: 게임을 새로 시작하려면 1, 종료하려면 2를 반환
	 */
	private int moreGame() {
		Scanner sc = new Scanner(System.in);
		boolean isSuccess = false; 
		String isMore = "";
		
		while (!isSuccess) {
			System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
			isMore = sc.nextLine();
			isSuccess = checkPattern2(isMore);
		}
		return Integer.parseInt(isMore);
	}
	
	/**
	 * 유저가 입력한 수가 '1 또는 2'인지 유효성 검사를 하는 함수
	 * 
	 * @param	: 유저가 입력한 수(1자리). 유효성 검사 시 사용됨.
	 * @return 	: 유저가 입력한 수가 '1 또는 2'이면 true, 아니면 false를 반환.
	 */
	public boolean checkPattern2(String isMore) {
		String numberPattern = "^([1-2]{1})$";
		
		if (Pattern.matches(numberPattern, isMore)) {
			return true;
		}
		System.out.println("1 또는 2만 입력할 수 있습니다.");
		return false;
	}
	
	public static void main(String[] args) {
		BaseballGame game = new BaseballGame();
		int moreGame = game.startGame();
		
		while (moreGame==1) {
			moreGame = game.startGame();
		}
	}
}
