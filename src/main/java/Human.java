/**
 * 플레이어 구현 클래스
 * @version 2.0
 * @date 2019.03.23
 * @author 이상원
 */
public class Human {

    /** 100의 자리, 10의 자리, 1의 자리 등 총 3개의 숫자를 일컫는 변수 **/
    static final int NUM_OF_BALLS = 3;

    /** 사람이 쓴 숫자를 자릿수로 나눠서 보관하는 변수 **/
    private int[] humanNumArray;

    /** 사람이 쓴 숫자를 보관하는 변수 **/
    private int inputNum;

    /**
     * humanNumArray에 자릿수만큼 공간을 할당한다.
     */
    public Human() {
        this.humanNumArray = new int[NUM_OF_BALLS];
    }

    /**
     * 사용자가 쓴 숫자를 inputNum에 보관한다.
     * @param inputNum 사용자가 쓴 숫자를 매개변수로 받는다.
     */
    public void setInputNum(int inputNum){
        this.inputNum = inputNum;
        divideNum();
    }

    /**
     * private으로 선언된 humanNumArray 변수를 반환한다.
     * @return 100의 자리, 10의 자리, 1의 자리로 숫자를 나눈 결과를 가진 배열을 반환한다.
     */
    public int[] getHumanNumArray(){
        return humanNumArray;
    }

    /**
     * 사용자가 넣은 수에 같은 숫자가 포함되어 있는지 확인한다.
    .* @return 같은 숫자가 있다면 true를 그렇지 않다면 false를 반환한다.
     */
    public boolean isValid(){
        if((humanNumArray[0] == humanNumArray[1])
                || (humanNumArray[0] == humanNumArray[2])
                || (humanNumArray[1] == humanNumArray[2])){
            return false;
        }
        return true;
    }

    /**
     * 사용자가 넣은 수를 배열에 나눈다.
     */
    public void divideNum(){
        humanNumArray[0] = inputNum / 100;
        inputNum = inputNum % 100;
        humanNumArray[1] = inputNum / 10;
        humanNumArray[2] = inputNum % 10;
    }
}
