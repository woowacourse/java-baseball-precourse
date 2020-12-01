package domain;

import java.util.ArrayList;
import java.util.List;

/**
 * 게임에 참여하는 컴퓨터(상대방)와 유저(사용자)가 상속하는 클래스
 * 기능 1. 객체가 가진 숫자 리스트를 그대로 반환
 * 기능 2. 객체가 가진 숫자 리스트의 인덱스에 속하는 값 반환
 * 기능 3. 객체가 가진 숫자 리스트에 값을 추가
 * 기능 4. 개체가 가진 숫자 리스트를 새로운 숫자 리스트 객체로 초기화
 */
public abstract class Player {
	private List<Integer> numbers = new ArrayList<Integer>();
	
	/** 객체가 가진 숫자 리스트를 그대로 반환 */
	public List<Integer> getNumbers(){
		return this.numbers;
	}
	
	/** 객체가 가진 숫자 리스트의 인덱스에 속하는 값 반환 */
	public Integer getNumber(int idx) {
		return numbers.get(idx);
	}
	
	/** 객체가 가진 숫자 리스트에 값을 추가 */
	public void addNumber(Integer number) {
		numbers.add(number);
	}
	
	/** 개체가 가진 숫자 리스트를 새로운 숫자 리스트 객체로 초기화 */
	public void clearNumbers() {
		this.numbers = new ArrayList<Integer>();
	}
}
