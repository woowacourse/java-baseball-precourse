import java.util.*;

/*
* 숫자 야구게임
* 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임!
* @version          1.1(2019.03.27)
* @author           김종윤
*/

public class BaseBallGame {
    /*
    * 구현 기능
    * 1. 게임 다시 시작 여부 확인
    * 2. 게임 진행
    * 3. 플레이어 입력 받기
    * 4. 랜덤 숫자 생성(중복 X)
    * 5. 숫자 각 자리수별로 나누기
    * 6. 정답 비교
    * 7. 정답 판별 및 힌트 제공
    */

    /* 최대 자리 수는 3 */
    static final int MAX_DIGIT = 3;

    public static void main(String[] args) {
        BaseBallGame baseBallGame = new BaseBallGame();
        boolean isRestart = true;
        while(isRestart){
            baseBallGame.playGame();
            isRestart = baseBallGame.checkingRestart();
        }
        System.out.println("수고하셨습니다! 모든 게임이 종료되었습니다.");
    }

    /*
     * 게임 다시 시작 여부 확인
     *
     * @return boolean 사용자에게 입력을 받아 1: true, 2: false 반환
     */
    private boolean checkingRestart(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");

        Scanner sc = new Scanner(System.in);
        int re = sc.nextInt();

        if(re == 1) return true;
        else return false;
    }

    /*
     * 게임 진행
     */
    private void playGame(){
        // 정답 생성
        ArrayList<Integer> answer = createRandomNum();

        ArrayList<Integer> inputNums;

        boolean isCorrect = false;

        while(true){
            if(isCorrect) {
                System.out.println(MAX_DIGIT + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
            inputNums = inputData();
            int[] strikeAndBallCnt = compareAnswer(inputNums, answer);
            isCorrect = checkAnswerAndOutputHint(strikeAndBallCnt);
        }
    }

    /*
     * 플레이어(나)의 입력 받아 각 자리수 별로 나누기
     *
     * @return ArrayList<Integer> 제시한 숫자 자리수별 반환
     */
    private ArrayList<Integer> inputData(){
        ArrayList<Integer> inputNums;

        System.out.print("숫자를 입력해주세요 : ");

        Scanner sc = new Scanner(System.in);
        int data = sc.nextInt();

        inputNums = inputNumSplit(data);

        return inputNums;
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
     * 숫자를 각각 나누어 저장
     *
     * @param num 숫자
     * @return ArrayList<Integer> 숫자를 각각 분리하여 반환
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
     * 입력 받은 (분리된)숫자와 정답과 비교하여 스트라이크 수와 볼 수 계산
     *
     * @param input 플레이어가 입력한 숫자
     * @param answer 정답
     * @return int[] 스트라이크 수와 볼 수를 반환
     */
    private int[] compareAnswer(ArrayList<Integer> input, ArrayList<Integer> answer){
        //cnt[0]: strikeCnt, cnt[1]: ballCnt
        int[] cnt = new int[2];

        // 정답과 비교하여 스트라이크 수와 볼 수 체크
        for(int i = 0; i < MAX_DIGIT; i++) {
            if (input.get(i).equals(answer.get(i))) cnt[0]++;
            else if (answer.contains(input.get(i))) cnt[1]++;
        }

        return cnt;
    }

    /*
     * 스트라이크 수와 볼 수를 확인하여 정답인지 확인하고 힌트를 제공
     *
     * @param strikeAndBallCnt 스트라이크 수와 볼 수
     * @return boolean 정답 확인 결과 반환
     */
    private boolean checkAnswerAndOutputHint(int[] strikeAndBallCnt){
        int strikeCnt = strikeAndBallCnt[0], ballCnt = strikeAndBallCnt[1];

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
