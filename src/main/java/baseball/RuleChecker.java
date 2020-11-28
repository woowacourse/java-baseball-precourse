package baseball;

public class RuleChecker {
    static final int NUMBEROFBALL = 3 ;
    static final int STRIKEPOSITION = 0;
    static final int BALLPOSITION = 1;


    public int[] gradePoints(int[] userInput, int[] gameBallSet) {
        int[] gradePoints = new int[2];
        int strikeNumberThisTurn = 0;
        int ballNumberThisTurn = 0;

        for(int position =0 ; position <NUMBEROFBALL ; position++) {
           strikeNumberThisTurn += gradeStrike(userInput, gameBallSet, position);
           ballNumberThisTurn += gradeBall(userInput,gameBallSet,position);
        }
        strikeNumberThisTurn = gradePoints[STRIKEPOSITION];
        ballNumberThisTurn = gradePoints[BALLPOSITION];

        return gradePoints;
    }

    public int gradeStrike(int[] userInput, int[] gameBallSet, int turn) {
        int thisStrike =0;

        if (userInput[turn] == gameBallSet[turn]) {
            thisStrike += 1;
        }

        return thisStrike;
    }

    public int gradeBall(int[] userInput, int[] gameBallSet, int turn) {
        int thisBall = 0;

        for(int lotatingTurn =0 ; lotatingTurn<NUMBEROFBALL ; lotatingTurn++) {
           if ((lotatingTurn != turn ) && (userInput[turn] == gameBallSet[lotatingTurn])) {
               thisBall +=1;
           }
        }

        return thisBall;
    }
}
