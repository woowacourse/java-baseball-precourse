import java.util.Random;

/**
 * 컴퓨터 구현 클래스
 * @version 2.0
 * @date 2019.03.23
 * @author 이상원
 */
public class Computer {
    /*클래스의 구현 주석*/

    /** 100의 자리, 10의 자리, 1의 자리 등 총 3개의 숫자를 일컫는 변수 **/
    static final int NUM_OF_BALLS = 3;

    /** 컴퓨터가 뽑은 숫자를 자릿수로 나눠서 보관하는 변수 **/
    private int[] comNumArray;

    /** 컴퓨터가 뽑은 숫자를 보관하는 변수 **/
    private int randomNum;

    /**
     * comNumArray에 자릿수만큼 공간을 할당한다.
     */
    public Computer() {
        this.comNumArray = new int[NUM_OF_BALLS ];
    }

    /**
     * private으로 선언된 comNumArray 변수를 반환한다.
     * @return 100의 자리, 10의 자리, 1의 자리로 숫자를 나눈 결과를 가진 배열을 반환한다.
     */
    public int[] getComNumArray(){
        return comNumArray;
    }

    /**
     * 랜덤으로 숫자를 만든 후 그 숫자를 randomNum에 담는 함수이다.
     */
    public void makeRandomNum(){
        while (true){
            Random ran = new Random();
            this.randomNum = ran.nextInt(990) + 10;
            divideNum(randomNum);
            if(isValid()) break;
        }
    }

    /**
     * 랜덤으로 뽑은 수에 같은 숫자가 포함되어 있는지 확인한다.
.    * @return 같은 숫자가 있다면 true를 그렇지 않다면 false를 반환한다.
     */
    public boolean isValid(){
        if((comNumArray[0] == comNumArray[1])
                || (comNumArray[0] == comNumArray[2])
                || (comNumArray[1] == comNumArray[2])){
            return false;
        }
        return true;
    }

    /**
     * 테스트용으로, 컴퓨터가 무슨 숫자를 뽑았는지 보여주는 함수이다.
     */
    public void showNum(){
        for(int i:comNumArray) {
            System.out.print("i: " + i);
        }
        System.out.println();
    }

    /**
     * 게임을 다시 시작하기 위하여 컴퓨터에게 새로운 랜덤 숫자를 뽑게하는 함수이다.
     */
    public void reset(){
        makeRandomNum();
    }

    /**
     * 뽑은 숫자를 배열에 나눈다.
     * @param inputNum 뽑은 숫자를 인자로 받는다.
     */
    public void divideNum(int inputNum){
        comNumArray[0] = inputNum / 100;
        inputNum = inputNum % 100;
        comNumArray[1] = inputNum / 10;
        comNumArray[2] = inputNum % 10;
    }
}
