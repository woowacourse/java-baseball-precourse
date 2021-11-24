package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.Set;

import static util.GameConstant.*;

class GameProvider {
    private int[] answer = new int[NUMBER_LENGTH];

    public GameProvider(){
        putRandomNumbers();
    }

    public void generateAnswer(){
        while (isDuplicateNumberExist()){
            putRandomNumbers();
        }
    }

    private void putRandomNumbers(){
        for(int i = 0 ; i < NUMBER_LENGTH; i++){
          answer[i] = Randoms.pickNumberInRange(START_NUMBER,END_NUMBER);
        }
    }

    private boolean isDuplicateNumberExist(){
        Set<Integer> tempSet = new HashSet<>();
        for(int i = 0 ; i < answer.length; i++){
            tempSet.add(answer[i]);
        }
        if(findDuplicateNumber(tempSet)){
            return true;
        }
        return false;
    }

    private boolean findDuplicateNumber(Set<Integer> tempSet) {
        return tempSet.size() != NUMBER_LENGTH;
    }

    /**
     * Test, Debug 용 toString Override
     * @return Game Answer = 1 2 3
     */
    @Override
    public String toString() {
        return "Game Answer =" + answer[0] + " " + answer[1] + answer[2];
    }

    public int[] getAnswer() {
        return answer;
    }
}
