package baseballgame.inputprocessor;

public class Processor {
    public Processor(){

    }
    public static String getHint(String randomNumber,String inputNumber){
        int strikeCount = checkStrike(randomNumber,inputNumber);
        if(strikeCount == 3) return "3스트라이크";
        int ballCount = checkBall(randomNumber,inputNumber);
        if(strikeCount ==0 && ballCount !=0) return ballCount+"볼";
        if(strikeCount !=0 && ballCount == 0) return strikeCount+"스트라이크";
        if(strikeCount ==0 && ballCount ==0) return "낫싱";

        return ballCount+"볼 " + strikeCount+"스트라이크";

    }
    private static int checkBall(String randomNumber,String inputNumber){
        int count =0;
        if(inputNumber.charAt(0)!=randomNumber.charAt(0)
                &&randomNumber.contains(String.valueOf(inputNumber.charAt(0)))) count++;
        if(inputNumber.charAt(1)!=randomNumber.charAt(1)
                &&randomNumber.contains(String.valueOf(inputNumber.charAt(1)))) count++;
        if(inputNumber.charAt(2)!=randomNumber.charAt(2)
                &&randomNumber.contains(String.valueOf(inputNumber.charAt(2)))) count++;
        return count;
    }
    private static int checkStrike(String randomNumber,String inputNumber){
        int count = 0;
        if(inputNumber.charAt(0)==randomNumber.charAt(0)) count++;
        if(inputNumber.charAt(1)==randomNumber.charAt(1)) count++;
        if(inputNumber.charAt(2)==randomNumber.charAt(2)) count++;
        return count;
    }
}
