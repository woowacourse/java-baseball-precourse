package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.LinkedHashSet;
import java.util.Set;

import static util.GameConstant.*;

class GameProvider {
    private int[] systemAnswer = new int[NUMBER_LENGTH];
    private String gameStatus;
    private GameScore gameScore;

    /**
     * 최초 정답 생성
     */
    public GameProvider(){
        gameStatus = ON_GOING;
        gameScore = new GameScore();
        generateAnswer();
    }

    /**
     * 중복없는 SystemAnswer 생성
     */
    private void generateAnswer(){
        Integer[] tempArr = createTempAnswer();

        for(int i = 0 ; i < NUMBER_LENGTH; i++){
            systemAnswer[i] = tempArr[i];
        }
    }

    private Integer[] createTempAnswer() {
        Set<Integer> tempSet = new LinkedHashSet<>();
        while (tempSet.size() < NUMBER_LENGTH){
            tempSet.add(Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER));
        }
        return tempSet.toArray(new Integer[3]);
    }

    /**
     * 정답 확인
     * @param playerAnswer
     * @return gameScore, 출력을 위한 return
     */
    public GameScore checkAnswer(int[] playerAnswer){
        for(int i = 0; i < NUMBER_LENGTH; i++){
            int findIndex = checkStrikeOrBall(playerAnswer[i]);
            addStrikeOrBall(i, findIndex);
        }
        if(gameScore.getStrike() == NUMBER_LENGTH){
            gameStatus = CORRECT;
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

    /**
     * Game 재시작 혹은 종료 여부 확인
     */
    public void checkRestartOrStop(String input){
        if(input.equals(RESTART)){
            gameStatus = ON_GOING;
            generateAnswer();
            return;
        }
        gameStatus = STOP;
    }

    /**
     * Test, Debug 용 toString Override
     * @return Game Answer = 123
     */
    @Override
    public String toString() {
        return "Game Answer = " + systemAnswer[0] + systemAnswer[1] + systemAnswer[2];
    }

    public String getGameStatus() {
        return gameStatus;
    }


}
