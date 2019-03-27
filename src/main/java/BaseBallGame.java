import java.io.BufferedReader;
import java.io.InputStreamReader;


/**
 * BaseBallGame
 *
 * @version 1.00 2019.03.27
 * @author 최성찬
 *
 */

public class BaseBallGame {

    /** 임의의 3자리 수 */
    private int[] num;
    /** 사용자 입력 3자리 수 */
    private int[] userNum;
    /** 스트라이크 갯수 */
    private int strike;
    /** 볼의 갯수 */
    private int ball;
    /** 게임의 종료 여부 */
    private boolean gameOver;
    /** 다음 게임 진행 여부 */
    private boolean hasNextGame;
    /** 사용자 입력을 받을 객체 */
    private BufferedReader br;

    /** 클래스 변수 초기화 */
    public BaseBallGame(){
        this.num = new int[3];
        this.userNum = new int[3];
        this.hasNextGame = true;
        this.br = new BufferedReader(new InputStreamReader(System.in));
    }

    /** 게임에 사용되는 변수 초기화 */
    public void init() {
        this.strike = 0;
        this.ball = 0;
        this.gameOver = false;
        this.setRandomNum();
    }

    /** 임의의 3수를 저장 */
    public void setRandomNum() {
        for(int i=0; i<3; i++) {
            int value = (int) (Math.random()*9) +1;
            if(this.existSameValue(i,value)) { i--; continue;}
            else{ this.num[i] = value; }
        }
    }

    /**
     * 임의의 3수에서 중복값 여부 판별
     * @param index 첫번째 자리 부터 index 전까지 수를 판별
     * @param value 해당 값과 같은 값이 있는지 확인
     * */
    public boolean existSameValue(int index, int value) {
        boolean res = false;
        for(int i=0; i<index; i++) {
            if(this.num[i] == value) { res = true; break; }
        }
        return res;
    }

    /** 사용자 입력을 받아 3개의 수 저장 */
    public boolean setUserNum() {
        String userInput = null;
        boolean res = false;

        try {
            this.showMessage("숫자를 입력해주세요");
            userInput = this.br.readLine();
            if(userInput.length() != 3) {
                this.showMessage("유요하지 않은 입력 입니다.");
            }else {
                this.setUserNumArr(userInput);
                res = true;
            }
        }catch(Exception e) {
            this.showMessage("오류가 발생했습니다.");
        }
        return res;
    }

    /**
     * 3자리 문자열 수를 배열로 저장
     * @param userInput 3자리 수를 표현하는 문자열
     */
    public void setUserNumArr(String userInput) {

        String[] arr = userInput.split("");
        for(int i=0; i<3; i++) {
            this.userNum[i] = Integer.parseInt(arr[i]);
        }
    }

    /** 저장되어있는 임의의 수와 사용자 입력수를 비교하여 strike ball 값을 저장 */
    public void setStrikeAndBall() {

        int strike = 0;
        int ball = 0;

        for(int i=0; i<3; i++) {
            int[] value = this.compareToUserNum(i);
            strike += value[0];
            ball += value[1];
        }

        this.strike = strike;
        this.ball = ball;
    }

    /** 임의의 수 1자리와 사용자 입력 수 3자리를 비교하여 strike ball 값 반환
     * @param idx 비교할 임의의 수의 인덱스
     * @return int[0] = strike 값, int[1] = ball 값
     * */
    public int[] compareToUserNum(int idx){

        int[] res = new int[2];
        int strike = 0;
        int ball = 0;

        for(int j=0; j<3; j++) {
            if(this.num[idx] == this.userNum[j]) {
                if(idx == j) { strike++; }
                else { ball++; }
            }
        }

        res[0] = strike;
        res[1] = ball;

        return res;
    }

    /** 게임 결과를 저장 */
    public void setGameResult() {
        this.gameOver = (this.strike == 3) ? true : false;
    }

    /** 사용자에게 메세지를 보여주는 기능 */
    public void showMessage(String msg) {
        System.out.println(msg);
    }

    /** 게임 결과를 사용자에게 보여주는 기능 */
    public void showGameResult() {
        String outPutString = "";
        if(this.strike > 0) { outPutString += this.strike+" 스트라이크 "; }
        if(this.ball > 0) { outPutString += this.ball+" 볼"; }
        if(this.strike == 0 && ball == 0) { outPutString = "낫싱";}
        if(this.strike == 3) {
            outPutString += "\n3개의 숫자를 모두 맞히셨습니다! 게임 종료"
                    + "\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
        }

        this.showMessage(outPutString);
    }

    /** 게임 진행 여부(사용자 입력)을 받아와 저장 */
    public boolean setNextGameState() {
        String userInput = null;
        boolean res = false;
        try {
            userInput = br.readLine();
            if(!userInput.equals("1") && !userInput.equals("2")) {
                this.showMessage("유요하지 않은 입력 입니다. 1 또는 2를 입력해주세요.");
            }else {
                this.hasNextGame = userInput.equals("1") ? true : false;
                res = true;
            }
        } catch (Exception e) {
            this.showMessage("입력 오류입니다. 다시 입력해주세요.");
        }
        return res;
    }
}