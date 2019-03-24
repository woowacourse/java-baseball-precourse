import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class BaseBallGame {
	BufferedReader in;
	Random random;
	boolean[] picked;
	int[] targetNo;
	int pickCount;
	boolean isFinished;
	boolean isCorrect;
	int[] evalResult;
	
	
	
	public BaseBallGame() {
		in = new BufferedReader(new InputStreamReader(System.in));
		random = new Random();
		picked = new boolean[10];
		targetNo = new int[3];
		pickCount = 0;
		isFinished = false;
		isCorrect = false;
		evalResult = new int[2];
	}

	private void init() {
		for(int i = 0; i < 10; i++) {
			picked[i] = false;
		}
		pickCount = 0;
		
		while(pickCount < 3) {
			int currentPick = random.nextInt(10);
			if(!picked[currentPick]) {
				targetNo[pickCount++] = currentPick;
				picked[currentPick] = true;
			}
		}
		System.out.println(targetNo[0] + " " + targetNo[1] + " " + targetNo[2]);
	}
	
	private boolean isCorrectInput(String s) {
		boolean isCorrect = s.matches("^(?!.*(.).*\\1)\\d{3}$");
		if(!isCorrect) {
			System.out.println("잘 못된 입력입니다.");
		}
		return isCorrect;
	}
	
	/**
	 * 3strike일 경우 true,
	 * 나머지 false 리턴 과 동시에 evalResult[0]에 스트라크 갯수 evalResult[1]에 볼 갯수
	 */
	private boolean evaluate(String s) {
		int strikeCount = 0;
		int ballCount = 0;
		for(int i = 0; i < 3; i++) {
			int currentInputNo = s.charAt(i)-'0';
			if(targetNo[i] == currentInputNo) {
				++strikeCount;
			}
			if(picked[currentInputNo]) {
				++ballCount;
			}
		}
		evalResult[0] = strikeCount;
		evalResult[1] = ballCount-strikeCount;
		return strikeCount == 3;
	}
	
	public void start() throws IOException {
		String userInput;
		boolean correctInputForFinish;
		while(!isFinished) {
			init();
			correctInputForFinish = false;
			isCorrect = false;
			while(!isCorrect) {
				System.out.println("숫자를입력해주세요 : ");
				userInput = in.readLine();
				
				//잘 못된 입력 일 경우
				if(!isCorrectInput(userInput)) {
					continue;
				}
				
				if(evaluate(userInput)) {
					while(!correctInputForFinish) {
						isCorrect = true;
						System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
						System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
						userInput = in.readLine();
						if(userInput.equals("1")) {
							correctInputForFinish = true;
						}else if(userInput.equals("2")) {
							correctInputForFinish = true;
							isFinished = true;
						}
					}
				}else {
					if(evalResult[0] == 0 && evalResult[1] == 0) {
						System.out.print("낫싱");
					}else {
						if(evalResult[0] != 0) {
							System.out.print(evalResult[0] + "스트라이크 ");
						}
						if(evalResult[1] != 0) {
							System.out.print(evalResult[1] + "볼");
						}
					}
					System.out.println();
				}
				
			}
		}
		
	}
}
