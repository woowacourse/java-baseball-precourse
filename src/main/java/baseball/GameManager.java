package baseball;

import java.util.ArrayList;

public class GameManager {

    private final User user;
    private final Opponent opponent;

    public GameManager(User user, Opponent opponent){
        this.user = user;
        this.opponent = opponent;
    }

    public boolean gameResult(){
        if(checkThreeStrike()){
            System.out.println(Constants.RESULT_THREE_STRIKES);
            return true;
        }
        if(isNothing()){
            System.out.println(Constants.RESULT_NOTHING);
            return false;
        }
        int strikes = countStrikes();
        int balls = countBalls();
        System.out.println(balls + Constants.RESULT_BALLS + strikes + Constants.RESULT_STRIKES);
        return false;
    }

    private boolean checkThreeStrike(){
        ArrayList<Integer> opponentBalls = opponent.getBaseballs();
        ArrayList<Integer> userBalls = user.getBaseballs();
        if(userBalls.equals(opponentBalls)){
            return true;
        }
        return false;
    }

    private int countStrikes(){
        int count = 0;
        ArrayList<Integer> opponentBalls = opponent.getBaseballs();
        ArrayList<Integer> userBalls = user.getBaseballs();
        for(int i = 0; i < userBalls.size(); i++){
            if(userBalls.get(i).equals(opponentBalls.get(i))){
                count++;
            }
        }
        return count;
    }

    private int countBalls(){
        int count = 0;
        ArrayList<Integer> opponentBalls = opponent.getBaseballs();
        ArrayList<Integer> userBalls = user.getBaseballs();
        for(int userBall : userBalls){
            if(opponentBalls.contains(userBall) &&
                    opponentBalls.indexOf(userBall) != userBalls.indexOf(userBall)){
                count++;
            }
        }
        return count;
    }

    private boolean isNothing(){
        ArrayList<Integer> userBalls = user.getBaseballs();
        for(int ball : userBalls){
            if(opponent.getBaseballs().contains(ball)){
                return false;
            }
        }
        return true;
    }
}
