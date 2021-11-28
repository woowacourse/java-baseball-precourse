package baseball;

import constant.CurrentState;
import constant.SystemMessage;

import java.util.ArrayList;
import java.util.Arrays;


public class BaseBall {
    private Referee referee;
    private RandomNumberGenerator randomNumberGenerator;
    private ArrayList<PlayerInput> playerInputs;
    private CurrentState currentState;


    public BaseBall(Referee referee, RandomNumberGenerator randomNumberGenerator, PlayerInput... playerInputs) {
        this.referee = referee;
        this.randomNumberGenerator = randomNumberGenerator;
        this.playerInputs = new ArrayList<>(Arrays.asList(playerInputs));
        this.currentState = CurrentState.PLAYING;
    }

    public void playGame() {
        int randomNumber = randomNumberGenerator.generateRandomNumber();
        int predict = SystemMessage.ZERO;
        do {
            predict = getPlayerInput();
            referee.calculateBallCount(randomNumber, predict);
        } while (!referee.canFinish());
        System.out.printf("%s\n", SystemMessage.END_GAME_MESSAGE);
        currentState = CurrentState.END;
    }

    public boolean decideNextGame() {
        if(getPlayerInput() == 1){
            return true;
        }
        return false;
    }

    private int getPlayerInput(){
        for(PlayerInput playerInput : playerInputs){
            if(playerInput.isSatisfiedBy(currentState)){
                return playerInput.getPlayerInput();
            }
        }
        return SystemMessage.ZERO;
    }


}
