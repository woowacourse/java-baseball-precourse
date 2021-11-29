package baseball;
import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;

public class Round {
	public static final int NUMBER_DIGIT= 3;
	public static final int MIN_RANGE= 1;
	public static final int MAX_RANGE= 9;
	
	private Computer computer;
	private int cnt_strike;
	private int cnt_ball;
	
	public Round(Computer computer) {
		this.computer= computer;
		this.cnt_ball= 0;
		this.cnt_strike= 0;
	}
	
	public void init() {
		computer.init();
		cnt_ball= 0;
		cnt_strike= 0;
	}
	
	public void play() {
		ArrayList<Integer> userInputList;
		while(true) {
			//숫자를 입력해주세요
			System.out.printf("숫자를 입력해주세요 : ");
			String userInput= readLine();
			//유효성 검사
			validateInputType(userInput);
			userInputList= toIntegerList(userInput);
			validateInputLength(userInputList);
			validateInputDistinct(userInputList);
			validateInputRange(userInputList);
		}
	}
	
	//userInput str to Integer List
	private ArrayList<Integer> toIntegerList(String str_input){
		ArrayList<Integer> inputList= new ArrayList<>();
		int num;
		for(int i=0; i<NUMBER_DIGIT; i++) {
			num= Integer.parseInt(str_input.split("")[i]);
			inputList.add(num);
		}
		return inputList; 
	}
	
	/******유효성 검사를 위한 코드******/
	//유효성 검사: 숫자 외의 문자를 입력함
	private void validateInputType(String input) {
		try {
			Integer.parseInt(input);
		}catch(NumberFormatException e){
			throw new IllegalArgumentException("Type Error: 숫자만 입력하세요.");
		}
	}
	
	//유효성 검사: 숫자를 3개 넘게 입력함
	private void validateInputLength(ArrayList<Integer> input) {
		if(input.size()>NUMBER_DIGIT)
			throw new IllegalArgumentException("Length Error: 숫자가 4개 이상입니다. 1~9 숫자 중에 3개만 입력해주세요.");
	}
	
	//유효성 검사: 중복 숫자 입력
	private void validateInputDistinct(ArrayList<Integer> input) {
		if(input.stream().distinct().count()<NUMBER_DIGIT) {
			throw new IllegalArgumentException("Duplication Error: 중복된 숫자가 입력되었습니다.");
		}
	}
	
	//유효성 검사: 범위밖의 숫자
	private void validateInputRange(ArrayList<Integer> input) {
		for(int i: input) {
			if(i<MIN_RANGE||i>MAX_RANGE) {
				throw new IllegalArgumentException("Range Error: 범위 밖의 숫자입니다.");
			}
		}
	}
}
