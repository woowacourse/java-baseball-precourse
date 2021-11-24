package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.Set;

import static util.GameConstant.*;

class GameProvider {
    private int[] systemAnswer = new int[NUMBER_LENGTH];
    private GameStatus gameStatus;
    private GameScore gameScore;

    /**
     * 최초 생성자에서 정답 생성
     */
    public GameProvider(){
        gameStatus = GameStatus.START;
        gameScore = new GameScore();
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
        for(int i = 0; i < NUMBER_LENGTH; i++){
            int findIndex = checkStrikeOrBall(playerAnswer[i]);
            addStrikeOrBall(i, findIndex);
        }
        if(gameScore.getStrike() == NUMBER_LENGTH){
            gameStatus = GameStatus.PAUSE;
        }
        return gameScore;
    }

    private void addStrikeOrBall(int currentIndex, int findIndex) {
        if(findIndex == NO_SAME_VALUE){
            return;
        }
        if(findIndex == currentIndex){
           gameScore.addStrike();
            return;
        }
        gameScore.addBall();
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

    public GameStatus getGameStatus() {
        return gameStatus;
    }


}
