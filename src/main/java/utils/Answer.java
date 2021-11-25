package utils;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Answer{
    private int[] answer = new int[3];
    private boolean[] usedNum = new boolean[9];

    public void generateAnswer(){
        for(int digit = 0; digit < 3; digit++){
            int pickNum = pickNumberInRange(1,9);

            if (!usedNum[pickNum - 1]){
                usedNum[pickNum-1] = true;
                answer[digit] = pickNum;
                continue;
            }
            digit--;
        }
    }

    public int[] returnAnswer(){
        generateAnswer();
        return this.answer;
    }

}
