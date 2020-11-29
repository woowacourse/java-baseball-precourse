package baseball;

public class Referee {
    static final String STRIKE = "스트라이크";
    static final String BALL = "볼";
    static final String NOTHING = "낫싱";
    private static int strikeCount = 0;
    private static int ballCount = 0;

    public static String judgeNumber(String randomNumber, String inputNumber){
        String result = "";
        int strikeCount = 0;
        int ballCount = 0;

        for (int i=0; i < randomNumber.length(); i++){
            if(randomNumber.charAt(i) == inputNumber.charAt(i)){
                strikeCount++;
            }
            else if (randomNumber.contains(Character.toString(inputNumber.charAt(i)))){
                ballCount++;
            }
        }
        return judgeToString(strikeCount, ballCount);
    }
}
