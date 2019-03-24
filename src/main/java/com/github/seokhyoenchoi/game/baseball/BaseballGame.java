package com.github.seokhyoenchoi.game.baseball;

import java.util.ArrayList;
import java.util.List;


/**
*
* @description : BaseballGame
* @package : com.github.seokhyoenchoi.game.baseball
* @author : 최석현
* 
*/
public class BaseballGame {
	/**
	 * @desc 난수를 저장할 List
	 */
	private List<Integer> baseballNums;
	
	private static int MAX_BALL_SIZE = 3;
	
	/**
	 * @desc Test용. 모든 기능 구현 후 제거
	 */
	public List<Integer> getNums(){
		return baseballNums;
	}
	
	/**
	 * @desc List에 난수 저장
	 */
	public BaseballGame() {
		baseballNums = new ArrayList<>();

		while (baseballNums.size() < MAX_BALL_SIZE) {
			int randomNumber = (int)(Math.random() * 9 + 1);
			
			if(!baseballNums.contains(randomNumber)) {
				baseballNums.add(randomNumber);
			}
		}
	}
	
	public boolean checkNums(List<Integer> nums) {
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
			System.out.println(new BallType(strikes, balls));
			return false;
		}
	}
}