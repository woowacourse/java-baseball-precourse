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
    /** 사용자 입력을 받을 객체 */
    private BufferedReader br;

    /** 클래스 변수 초기화 */
    public BaseBallGame(){
        this.num = new int[3];
        this.userNum = new int[3];
        this.br = new BufferedReader(new InputStreamReader(System.in));
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

    /** 사용자에게 메세지를 보여주는 기능 */
    public void showMessage(String msg) {
        System.out.println(msg);
    }
}