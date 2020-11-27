package baseball;

import java.util.ArrayList;

public class User extends Player{
    public User(Baseball baseball){
        super(baseball);
    }

    public boolean gameResult(Opponent opponent){
        if(checkThreeStrike(opponent)){
            System.out.println(Constants.RESULT_THREE_STRIKES);
            return true;
        }
        if(isNothing(opponent)){
            System.out.println(Constants.RESULT_NOTHING);
            return false;
        }
        int strikes = countStrikes(opponent);
        int balls = countBalls(opponent);
        System.out.println(balls + Constants.RESULT_BALLS + strikes + Constants.RESULT_STRIKES);
        return false;
    }

    public boolean checkThreeStrike(Opponent opponent){
        if(getBaseballs().equals(opponent.getBaseballs())){
            return true;
        }
        return false;
    }

    public int countStrikes(Opponent opponent){
        int count = 0;
        ArrayList<Integer> opponentBalls = opponent.getBaseballs();
        ArrayList<Integer> userBalls = getBaseballs();
        for(int i = 0; i < getBaseballs().size(); i++){
            if(userBalls.get(i) == opponentBalls.get(i)){
                count++;
            }
        }
        return count;
    }

    public int countBalls(Opponent opponent){
        int count = 0;
        ArrayList<Integer> opponentBalls = opponent.getBaseballs();
        ArrayList<Integer> userBalls = getBaseballs();
        for(int userBall : userBalls){
            if(opponentBalls.contains(userBall) &&
                opponentBalls.indexOf(userBall) != getBaseballs().indexOf(userBall)){
                count++;
            }
        }
        return count;
    }

    public boolean isNothing(Opponent opponent){
        for(int ball : getBaseballs()){
            if(opponent.getBaseballs().contains(ball)){
                return false;
            }
        }
        return true;
    }
}
