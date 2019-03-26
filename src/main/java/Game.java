import java.util.Scanner;

/**
 * 게임플레이 구현 클래스
 * @version 2.0
 * @date 2019.03.23
 * @author 이상원
 */
public class Game {

    /** 스트라이크의 개수를 보관하는 함수 **/
    private int strikes;

    /** 볼의 개수를 보관하는 변수 **/
    private int balls;

    /**
     * 스트라이크와 볼의 개수를 0으로 초기화한다.
     */
    public Game(){
        this.strikes = 0;
        this.balls = 0;
    }

    /**
     * arr에 특정 숫자가 있는 지 확인하는 함수이다.
     * @param arr 자릿수로 나눠진 숫자를 보관하는 배열을 인자로 받는다.
     * @param target 찾고자 하는 숫자를 인자로 받는다.
     * @return 찾고자 하는 숫자가 있다면 배열의 인덱스를 그렇지 않다면 -1을 반환한다.
     */
    public int isThereNumber(int[] arr, int target){
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 컴퓨터가 뽑은 랜덤 숫자와 사용자가 넣은 숫자를 비교하여
     * 스트라이크와 볼을 결정한다.
     * @param humanNumArray 사용자의 숫자 배열이 기준이 된다.
     * @param comNumArray 컴퓨터의 숫자 배열이 비교 대상이 된다.
     * @return 3 스트라이크면 1 그렇지 않으면 0을 반환한다.
     */
    public int judgingScore(int[] humanNumArray, int[] comNumArray){
        int humanNumArrayLen = humanNumArray.length;
        for(int i = 0; i < humanNumArrayLen; i++) {
            /**
             * 찾고자 하는 숫자의 인덱스 값과 기준 배열의 인덱스값을 비교하여
             * 그 인덱스 값이 같으면 스트라이크,
             * 다르면 볼을 추가한다.
             */
            int comIdx = isThereNumber(comNumArray, humanNumArray[i]);
            if (comIdx == -1) {
                continue;
            } else if (i == comIdx) {
                strikes = strikes + 1;
            } else if (i != comIdx) {
                balls = balls + 1;
            }
        }
        if(strikes == 3) {
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * 사용자에게 게임을 계속하는지 물어보는 함수이다.
     * @return 지속한다면 true를 그렇지 않다면 false를 반환한다.
     */
    public boolean continueGame(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        if(choice == 1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 스트라이크와 볼을 0으로 초기화하는 함수이다.
     */
    public void initializeAgain(){
        this.strikes = 0;
        this.balls = 0;
    }

    /**
     * 스트라이크와 볼의 개수에 따라서 그 결과를 보여주는 함수이다.
     */
    public void showScore(){
        if(strikes == 0 && balls == 0) {
            System.out.println("낫싱");
        } else if(strikes == 0) {
            System.out.println(balls + " 볼");
        } else {
            System.out.println(strikes + " 스트라이크" + " " + balls + " 볼");
        }
    }
}
