import java.util.ArrayList;
import java.util.Random;

/**
 * 사용자가 맞힐 숫자를 보유하고 있는 컴퓨터 클래스
 * @author giantim
 */
public class Computer {
	/** 컴퓨터가 갖는 서로 다른 수로 이루어진 3자리의 수 */
    private ArrayList<Integer> computerNumberSet;
    
    /** 생성자. 3자리의 수를 새로 받는다. */
    public Computer() {
        computerNumberSet = new ArrayList<Integer>();

        setRandomNumber();
    }
    
    /** 
     * 10칸의 리스트를 이용해 수가 겹치지 않도록 검사하고
     * 컴퓨터가 갖는 배열에 수를 저장한다. 
     */
    private void setRandomNumber() {
        ArrayList<Boolean> checkList = new ArrayList<Boolean>();

        for (int i = 0; i < Constant.CHECKLIST_SIZE; i++) {
            checkList.add(false);
        }
        addNumber(checkList);
    }
    
    /**
     * Random 클래스를 이용해 1~9까지의 임의의 수를 할당하고
     * 지금까지 저장한 수와 겹치는지 확인한다.
     * 지금까지 할당된 수와 겹치지 않는다면 컴퓨터의 배열에 저장한다.
     * @param list 10칸의 배열로 수가 겹치지 않도록 검사한 결과를 저장한다.
     */
    private void addNumber(ArrayList<Boolean> list) {
        Random random = new Random();
        int ranNum;

        for (int i = 0; i < Constant.NUM_SIZE; ) {
            ranNum = random.nextInt(Constant.RAN_NUM_RANGE) + 1;
            while (list.get(ranNum).equals(false)) {
                list.set(ranNum, true);
                computerNumberSet.add(ranNum);
                i = i + 1;
            }
        }
    }
    
    /**
     * private으로 선언된 컴퓨터가 갖는 3자리의 수에 접근할 수 있도록 한다.
     * @return private으로 선언된 컴퓨터의 배열.
     */
    public ArrayList<Integer> getNumberSet() {
        return computerNumberSet;
    }
    
    /**
     * 사용자가 게임을 다시 시작하면 컴퓨터의 수를 새로 할당한다.
     */
    public void restartGame() {
        computerNumberSet.clear();
        setRandomNumber();
    }
}