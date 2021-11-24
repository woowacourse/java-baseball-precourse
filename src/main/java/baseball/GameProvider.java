package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.Set;

import static util.GameConstant.*;

class GameProvider {
    private int[] systemAnswer = new int[NUMBER_LENGTH];

    /**
     * 최초 생성자에서 정답 생성
     */
    public GameProvider(){
        putRandomNumbers();
    }

    /**
     * 최초에 생성된 정답을 바탕으로 중복값 탐색
     * 중복일 경우 정답 생성
     */
    public void generateAnswer(){
        while (!isNotDuplicateInSystemAnswer()){
            putRandomNumbers();
        }
    }

    public GameScore checkAnswer(int[] playerAnswer){
        GameScore gameScore = new GameScore();
        for(int i = 0; i < NUMBER_LENGTH; i++){
            int index = checkStrikeOrBall(playerAnswer[i]);
            if(index == NO_SAME_VALUE){
                continue;
            }
            if(index == i){
               gameScore.addStrike();
               continue;
            }
            gameScore.addBall();
        }
        return gameScore;
    }

    private int checkStrikeOrBall(int value){
        for(int i = 0 ; i < NUMBER_LENGTH; i++){
            if(value == systemAnswer[i]){
                return i;
            }
        }
        return NO_SAME_VALUE;
    }

    private void putRandomNumbers(){
        for(int i = 0 ; i < NUMBER_LENGTH; i++){
            systemAnswer[i] = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
        }
    }

    private boolean isNotDuplicateInSystemAnswer(){
        Set<Integer> tempSet = new HashSet<>();
        for(int i = 0 ; i < systemAnswer.length; i++){
            tempSet.add(systemAnswer[i]);
        }
        if(findDuplicateNumber(tempSet)){
            return true;
        }
        return false;
    }

    private boolean findDuplicateNumber(Set<Integer> tempSet) {
        return tempSet.size() == NUMBER_LENGTH;
    }

    /**
     * Test, Debug 용 toString Override
     * @return Game Answer = 123
     */
    @Override
    public String toString() {
        return "Game Answer =" + systemAnswer[0] + systemAnswer[1] + systemAnswer[2];
    }

}
