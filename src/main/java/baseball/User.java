package baseball;

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
        System.out.println(getBaseballs().size());
        for(int i = 0; i < getBaseballs().size(); i++){
            if(getBaseballs().get(i) == opponent.getBaseballs().get(i)){
                count++;
            }
        }
        return count;
    }
    public int countBalls(Opponent opponent){
        int count = 0;
        for(int i = 0; i < getBaseballs().size(); i++){
            if(opponent.getBaseballs().contains(getBaseballs().get(i)) &&
                    getBaseballs().get(i) != opponent.getBaseballs().get(i)){
                count++;
            }
        }
        return count;
    }
    public boolean isNothing(Opponent opponent){
        for(int i = 0; i < getBaseballs().size(); i++){
            if(opponent.getBaseballs().contains(getBaseballs().get(i))){
                return false;
            }
        }
        return true;
    }
}
