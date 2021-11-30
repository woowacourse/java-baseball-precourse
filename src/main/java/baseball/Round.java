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
			
			//볼 and 스트라이크 개수 확인
			cnt_strike= computer.cntStrike(userInputList);
			cnt_ball= computer.cntBall(userInputList);
			
			//결과 출력
			prtHint();
			//exit 조건: 3스트라이크일 경우
			if(cnt_strike==NUMBER_DIGIT) {
				break;
			}
		}
		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
	}
	
	//print hint: 볼/스트라이크/낫싱 출력함수
	private void prtHint() {
		StringBuilder sb= new StringBuilder();
		if(cnt_ball!=0) { //볼 있음
			sb.append(cnt_ball+"볼 ");
		}
		if(cnt_strike!=0) { //스트라이크 있음
			sb.append(cnt_strike+"스트라이크");
		}
		if(cnt_strike==0&&cnt_ball==0){ //낫싱
			System.out.println("낫싱");
			return;
		}
		System.out.println(sb.toString());
	}
	
	//userInput str to Integer List
	private ArrayList<Integer> toIntegerList(String str_input){
		ArrayList<Integer> inputList= new ArrayList<>();
		int num;
		for(int i=0; i<str_input.length(); i++) {
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
