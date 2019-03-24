package com.github.seokhyoenchoi.game.baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;


/**
*
* @description : Baseball Game
* @package : com.github.seokhyoenchoi.game.baseball
* @author : 최석현
* 
*/
public class BaseballGame { 
	
	/**
	 * @desc 난수를 저장할 List
	 */
	private List<Integer> baseballNums;
	
	/**
	 * @desc Scanner 상수
	 */
	private static final Scanner SCANNER = new Scanner(System.in);
	
	/**
	 * @desc Magic Numbers
	 */
	private static int MAX_BALL_SIZE = 3;
	private static int NUM_LOWER_BOUNDARY = 1;
	private static int NUM_UPPER_BOUNDARY = 9;
	private static int RESTART = 1;
	private static int QUIT = 2;
	
	public BaseballGame() {}
	
	/**
	 * @desc 난수 초기화
	 */
	public void init() {
		baseballNums = new ArrayList<>();

		while (baseballNums.size() < MAX_BALL_SIZE) {
			int randomNumber = (int)(Math.random() * NUM_UPPER_BOUNDARY + NUM_LOWER_BOUNDARY);
			
			if(!baseballNums.contains(randomNumber)) {
				baseballNums.add(randomNumber);
			}
		}
	}
	
	/**
	 * @desc Main Logic
	 */
	@SuppressWarnings("resource")
	public void start() {
		while(true) {
			printNumInputMessage();
			
			List<Integer> nums = new ArrayList<>();
			
			for(int i = 0; i < MAX_BALL_SIZE;i++) {
				nums.add(SCANNER.nextInt());
			}
			
			if(isDuplicated(nums)) {
				System.out.println("중복되지 않은 수를 입력해주세요.");
				continue;
			}
			
			if(!validNums(nums)) {
				System.out.println("범위 내의 수를 입력해주세요.");
				continue;
			}
			
			if(checkNums(nums)) {
				System.out.println("정답입니다!");
				printNums();
				break;
			}
		}
	}
	
	/**
	 * @desc 다시하기
	 */
	public boolean answerRestart() {
		System.out.println("다시하려면 " + RESTART + "을, 그만하려면 " + QUIT + "를 입력해주세요 : ");
		
		int restartFlag = 0;
		while(true) {
			restartFlag = SCANNER.nextInt();
			if(restartFlag == RESTART || restartFlag == QUIT) {
				break;
			} else {
				System.out.println(RESTART + " 혹은 " + QUIT + "를 입력해주세요.");	
			}
		}
		
		return restartFlag == RESTART ? true : false;
	}
	
	/**
	 * @desc 입력받은 수 Validation
	 */
	private boolean validNums(List<Integer> nums) {
		for(Integer num : nums) {
			if(num < NUM_LOWER_BOUNDARY || num > NUM_UPPER_BOUNDARY) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * @desc 중복 확인
	 */
	private boolean isDuplicated(List<Integer> nums) {
		Set<Integer> numSet = new HashSet<Integer>(nums);
		return nums.size() != numSet.size();
	}
	
	/**
	 * @desc Strike, Ball Check
	 */
	private boolean checkNums(List<Integer> nums) {
		int strikes = 0;
		int balls = 0;
		
		for(int i = 0; i < MAX_BALL_SIZE; i++) {
			if(nums.get(i) == baseballNums.get(i)) {
				strikes++;
			} else if(baseballNums.contains(nums.get(i))) {
				balls++;
			}
		}
		if(strikes == MAX_BALL_SIZE) {
			return true;
		} else {
			System.out.println(new BallType(strikes, balls) + "\n");
			return false;
		}
	}
	
	/**
	 * @desc List에 저장된 수 출력
	 */
	private void printNums() {
		System.out.print("답은 ");
		for(int i = 0; i < MAX_BALL_SIZE; i++) {
			System.out.print(baseballNums.get(i) + " ");
		}
		System.out.println("입니다." + "\n");
	}
	
	/**
	 * @desc Input Message 출력
	 */
	private void printNumInputMessage() {
		System.out.print(MAX_BALL_SIZE + "개의 수를 입력해주세요. (");
		System.out.print(NUM_LOWER_BOUNDARY - 1);
		System.out.print(" < n < ");
		System.out.print(NUM_LOWER_BOUNDARY + 1);
		System.out.println(") : ");
	}
}