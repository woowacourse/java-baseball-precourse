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

    /** 클래스 변수 초기화 */
    public BaseBallGame(){
        this.num = new int[3];
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

    /** 사용자에게 메세지를 보여주는 기능 */
    public void showMessage(String msg) {
        System.out.println(msg);
    }
}