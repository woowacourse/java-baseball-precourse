package baseball;

import camp.nextstep.edu.missionutils.Console;

public class PlayBall {

    public static void play(int[] generatedNumbers) {
        String guessResult;
        do {
            guessResult = startTurn(generatedNumbers);
        } while (!isFinished(guessResult));
    }

    private static String startTurn(int[] generatedNumbers){
        String guessResult = Player.guessNumber(generatedNumbers, Player.getPlayerInput());
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

    public static boolean isContinue() {
        System.out.println(SystemMessage.GAME_END_MESSAGE);
        System.out.println(SystemMessage.RESTART_SELECT_MESSAGE);
        String input = Console.readLine();
        if (Validator.isValidateChoice(input)) return input.equals(Constant.CHOICE_ONE);
        else throw new IllegalArgumentException(SystemMessage.WRONG_INPUT_MESSAGE);
    }
}
