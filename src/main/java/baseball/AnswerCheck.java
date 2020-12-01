package baseball;

public class AnswerCheck {
    public final static String ball = "볼";
    public final static String strike = "스트라이크";
    public final static  String nothing = "낫싱";

    public static boolean compareTrial(String answer, String userTrial) {
        int ballCnt = 0;
        int strikeCnt = 0;
        for (int i = 0; i < GamePlayer.NUMBER_LENGTH; i++) {
            if(answer.charAt(i)==userTrial.charAt(i)){ // condition of strike
                strikeCnt += 1;
            }else if(answer.contains(Character.toString(userTrial.charAt(i)))){ // condition of ball
                ballCnt += 1;
            }
        }
        if (ballCnt > 0 && strikeCnt > 0) {
            System.out.println(ballCnt+ball+" "+strikeCnt+strike);
        }else if (strikeCnt > 0 && ballCnt ==0){
            System.out.println(strikeCnt+strike);
            if (strikeCnt == 3) { // condition of game end
                return true;
            }
        }else if (strikeCnt == 0 && ballCnt > 0){
            System.out.println(ballCnt + ball);
        }else{
            System.out.println(nothing);
        }
        return false;
    }
}

