package baseball;
import camp.nextstep.edu.missionutils.*;
import java.util.ArrayList;

public class Baseball {
	private static final int DIGIT = 3;
	private String ranNum;
	private String userNum;
	
	public Baseball () {
		ranNum = "";
		userNum = "";
	}
	public void initialize () {
		ranNum = generateRanNum(DIGIT);
	}
	private String generateRanNum(int digit) {
		ArrayList <Character> list = new ArrayList<>();
		String res = "";
		while(list.size()<digit) {
			char tmp = Character.forDigit(Randoms.pickNumberInRange(1, 9), 10);
			
			if(list.contains(tmp)) {
				continue;
			}
			list.add(tmp);
		}
		for(char c : list) {
			res += c;
		}
		return res;
	}
	/*
	public void 게임 플레이 playGame () {
		String 출력할 메시지 result = "";
		
		while(true) {
			입력메시지 출력 ("숫자를 입력해주세요: ")
			유저입력수 userNum = next() 메소드로 입력받음
			int b = 볼 개수 카운팅 메소드 countBall 사용
			int s = 스트라이크 카운팅 메소드 countStrike 사용
			result = printResult(b,s)
			result 출력
			if(b == DIGIT) {
				break
			} 
		}
	}
	public boolean 재시작할지 Restart () {
		String 재시작 할지 선택 select = 유저에게 입력받음
		if(select가 "1"이라면) {
			return true
		}
		if(select가 "2"라면) {
			return false
		}
		return IllegalArgumentException
	}
	private String 결과출력 printResult (int 볼 개수 b, int 스트라이크 개수 s) {
		//스트라이크 개수와 볼 개수를 불러와서 결과를 출력해줌
		String res = "";
		if(스트라이크 == 0 && 볼 == 0) {
			return "낫싱"
		}
		if(볼 >0) {
			res += Integer.toString(b) + "볼 "
		}
		if(스트라이크 >0) {
			res += Integer.toString(s) + "스트라이크 "
		}
		if(스트라이크 == DIGIT) {
			res += "\n3개의 숫자를 모두 맞히셨습니다! 게임 종료 \n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n"
		}
		res = res.trim() 메소드로 앞뒤 공백 제거
		
		return res
	}
	
	private String 유저가 숫자를 입력하는 메소드 next () {
		//임의의 문자열을 유저에게 넘겨받은 후 legit한 값인지 검사
		String 유저입력숫자 num = Console.readLine()으로 입력받기
		String 입력숫자범위 numRegex = 숫자 1-9로 이루어진 3글자(정규표현식)
		
		if(num이 numRegex과 match하지 않거나) {
			throw new IllegalArgumentException()
		}
		if(hasSame(num)이 false라면) {
			throw new IllegalArgumentException()
		}
		return num
	}
	
	private int 스트라이크 갯수 countStrike(String 유저입력수) {
		//넘겨받은 랜덤수와 유저입력수를 비교하여 같은 자릿수에 있는 수가 같은 경우를 카운트
		int s = 스트라이크 수
		for(digit 수 만큼) {
			if(ranNum.charAt(po) == userNum.charAt(po)) {
				s++
			}
		}
		return s
	}
	
	private int 볼 갯수 countBall(String 유저입력수) {
		//랜덤수와 유저입력수를 비교하여 다른 자릿수에 있는 수가 같은 경우를 카운트
		int b = 볼 수
		for(digit 수 만큼) {
			int 인덱스 idx = 랜덤수가 유저입력수 각 자리수의 값을 포함하고 있는지 확인 후 index 추출
			if(idx가 -1 이상이고 유저입력수의 자릿수와 다르다면) {
				b++
			}  
		}
		return b
	}
	
	private boolean 중복 수 확인 hasSame (String target) {
		//유저가 같은 수를 입력했는지 확인
		HashSet <Character> 중복 확인용 set
		char [] charArr = target.toCharArray();
		for(charArr 길이 만큼) {
			set.add(charArr 요소들)
		}
		if(set 사이즈 == DIGIT) {
			return true
		}
		return false
	}
	*/

}
