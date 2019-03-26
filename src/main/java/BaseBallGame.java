
import javafx.util.Pair;

import java.util.*;

/*
* 숫자 야구게임
* 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임!
* @version          1.0(2019.03.26)
* @author           김종윤
*/

public class BaseBallGame {
    /*
    * 구현 기능
    * 1. 랜덤 숫자 생성(중복 X)
    * 2. 숫자 각 자리수별로 나누기
    * 3. 정답 판별
    */

    /* 최대 자리 수는 3 */
    static final int MAX_DIGIT = 3;

    public static void main(String[] args) {
        BaseBallGame baseBallGame = new BaseBallGame();
        int menu = 1;
        while(menu == 1){
            baseBallGame.playGame();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
            Scanner sc = new Scanner(System.in);
            menu = sc.nextInt();
        }
        System.out.println("수고하셨습니다! 모든 게임이 종료되었습니다.");
    }

    /*
     * 게임 진행
     */
    private void playGame(){
        ArrayList<Integer> answer = createRandomNum();
        ArrayList<Integer> inputNums;
        boolean isCorrect = false;
        System.out.println(answer);
        while(true){
            if(isCorrect) {
                System.out.println(MAX_DIGIT + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
            System.out.print("숫자를 입력해주세요 : ");
            Scanner sc = new Scanner(System.in);
            int input = sc.nextInt();
            inputNums = inputNumSplit(input);
            isCorrect = checkingAnswer(inputNums, answer);
        }
    }

    /*
    * 랜덤 숫자 3개 생성(1부터 9까지)
    * 숫자가 중복되지 않도록 생성
    *
    * @return ArrayList<Integer> 생성된 숫자들 반환
    */
    private ArrayList<Integer> createRandomNum(){
        ArrayList<Integer> randomNums = new ArrayList<>();
        int num;
        int numCnt = 0;
        while(numCnt < MAX_DIGIT){
            Random r = new Random();
            // 1부터 9까지 랜덤 수 생성
            num = r.nextInt(9) + 1;
            // 중복 확인
            if(randomNums.contains(num)) continue;

            randomNums.add(num);
            numCnt = randomNums.size();
        }
        return randomNums;
    }

    /*
     * 입력 받은 숫자를 각각 나누어 저장
     *
     * @param num 입력 받은 숫자
     * @return ArrayList<Integer> 입력된 숫자를 각각 분리하여 반환
     */
    private ArrayList<Integer> inputNumSplit(int num){
        ArrayList<Integer> inputNums = new ArrayList<>();
        int digits = MAX_DIGIT;
        while(digits > 0) {
            int divideNum = (int) Math.pow(10, digits - 1);
            inputNums.add(num / divideNum);
            num %= divideNum;
            digits--;
        }
        return inputNums;
    }

    /*
     * 입력 받은 (분리된)숫자와 정답과 비교하여 정답 확인
     * 스트라이크 수와 볼 수를 확인하여 힌트를 제공
     *
     * @param input 플레이어가 입력한 숫자
     * @param answer 정답
     * @return boolean 정답 확인 결과 반환
     */
    private boolean checkingAnswer(ArrayList<Integer> input, ArrayList<Integer> answer){
        int strikeCnt = 0, ballCnt = 0;

        // 정답과 비교하여 스트라이크 수와 볼 수 체크
        for(int i = 0; i < MAX_DIGIT; i++) {
            if (input.get(i).equals(answer.get(i))) strikeCnt++;
            else if (answer.contains(input.get(i))) ballCnt++;
        }

        // 정답을 확인하고 힌트 제공
        if(strikeCnt == MAX_DIGIT){
            System.out.println(MAX_DIGIT + " 스트라이크");
            return true;
        } else if(strikeCnt == 0 && ballCnt == 0){
            System.out.println("낫싱");
        } else if(ballCnt == 0){
            System.out.println(strikeCnt + " 스트라이크");
        } else if(strikeCnt == 0){
            System.out.println(ballCnt + " 볼");
        } else {
            System.out.println(strikeCnt + " 스트라이크 " + ballCnt + " 볼");
        }
        return false;
    }

}
