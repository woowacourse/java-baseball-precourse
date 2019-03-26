import java.util.HashMap;

public class Feature {

    // 클래스 안에 클래스 holder를 두는 Singleton
    private Feature(){ }
    private static class Featureholder{ public static final Feature INSTANCE = new Feature();}
    public static Feature getInstance(){ return Feature.Featureholder.INSTANCE; }

    public int checkNum(HashMap hashMap, String[] playerNum){
        int strike = 0, ball = 0, nothing=0;

        for(int i = 0 ; i < playerNum.length ; i++){
            if(!hashMap.containsValue(Integer.parseInt(playerNum[i]))){
                nothing++;
            } else if((int)hashMap.get(i) == Integer.parseInt(playerNum[i])){
                strike++;
            } else{
                ball++;
            }
        }

        printScore(strike, ball, nothing);
        return strike;
    }

    private void printScore(int strike, int ball, int nothing){
        if(nothing == 3){
            System.out.println("낫싱");
        } else if(strike == 3){
            System.out.println("3개의 숫자를 모두 맞추셨습니다! 게임 종료");
        } else if(ball == 0 || strike == 0){
            if(ball == 0) System.out.println(strike + " 스트라이크");
            if(strike == 0) System.out.println(ball + " 볼");
        } else{
            System.out.println(strike + " 스트라이크, " + ball + " 볼");
        }
    }


}
