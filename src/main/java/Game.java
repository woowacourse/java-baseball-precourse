import java.util.*;

public class Game {
  static int strike = 0;
  static int ball = 0;
  
  static void gameStart() {
    ArrayList<Integer> answer = Answer.answerCreate(); // 정답이 될 랜덤 숫자 생성
    ArrayList<Integer> input = inputSlice(); // 정답을 맞출 값을 입력

    while(checkAnswer(answer, input) != true) { // 정답일 경우 checkAnswer는 true를 반환
      input = inputSlice();                     // 정답이 아닐 경우 값을 다시 입력
    }
  }

  static ArrayList<Integer> inputSlice() { // 입력받은 숫자를 각 자릿수에 맞춰 ArryList 형태로 저장
		ArrayList<Integer> question = new ArrayList<Integer>();
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("숫자를 입력해주세요 : ");
    int nums = scanner.nextInt();
    
    question = Divider.divide(nums);

		if(nums < 100 || nums > 999 || Check.checkOverlap(question)) { // 100미만 999초과의 숫자를 입력받거나, 입력받은 숫자 중 중복되는 숫자가 있을 경우 재 입력
			System.out.println("잘못된 입력입니다.");
			inputSlice();
		} else { }

		return question;
  }
  
  static boolean checkAnswer(ArrayList<Integer> answer, ArrayList<Integer> input) { // 입력받은 값과 정답을 비교
    strike = 0;
    ball = 0;

		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				comparing(answer.get(i), input.get(j), i, j); // 각 자리값을 비교
			}
    }
    return ballCount();
  }

  static void comparing(int ans, int inp, int i, int j) {
    if(ans == inp) {
      if(i == j) {
        strike += 1;
      } 
      else {
        ball += 1;
      }
    }
  }
  
  static boolean ballCount() { // 결과를 출력함과 동시에 3스트라이크가 될 경우 true를 반환
		if(strike == 0 && ball == 0) {
			System.out.println("낫싱");
			return false;
		}
		else if(strike != 0 && ball == 0) {
			System.out.printf("%d 스트라이크\n", strike);
		}
		else if(strike == 0 && ball != 0) {
			System.out.printf("%d 볼\n", ball);
			return false;
		}
		else {
			System.out.printf("%d 스트라이크 %d 볼\n", strike, ball);
			return false;
    }
    
		if(strike == 3) {
			System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
			return true;
    } 
    else
			return false;
  }
}