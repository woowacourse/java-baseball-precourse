package com.github.seokhyoenchoi.game.baseball;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
*
* @description : BaseballGame
* @package : com.github.seokhyoenchoi.game.baseball
* @author : 최석현
* 
*/
public class BaseballGame {
	/**
	 * @desc 난수를 저장할 Set
	 */
	private Set<Integer> baseballNums;
	
	
	/**
	 * @desc Test용. 모든 기능 구현 후 제거
	 */
	public Set<Integer> getNums(){
		return baseballNums;
	}
	
	/**
	 * @desc Set에 난수 Setting
	 */
	public BaseballGame() {
		baseballNums = new HashSet<>(3);

		while (baseballNums.size() < 3) {
			int randomNumber = (int) (Math.random() * 9 + 1);
			
			if(!baseballNums.contains(randomNumber)) {
				baseballNums.add(randomNumber);
			}
		}
	}

}
