package baseball;

public class Game {

    public static void play(int[] generatedNumbers) {
        String guessResult;
        do {
            guessResult = startTurn(generatedNumbers);
        } while (!isFinished(guessResult));
    }

    private static String startTurn(int[] generatedNumbers){
        String guessResult = Player.guessNumber(generatedNumbers);
        System.out.println(guessResult);
        return guessResult;
    }

    private static boolean isFinished(String guessResult) {
        if(guessResult.equals(SystemMessage.THREE_STRIKE_MESSAGE)){
            System.out.println(SystemMessage.END_CONDITION_MESSAGE);
            return true;
        }
        return false;
    }
}
