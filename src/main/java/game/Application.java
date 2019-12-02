
/*
 * Application.java
 * @author crystal_rim
 * @version 1.0.0
 * @date 2019-12-02
 */
package game;

import game.domain.Game;
import game.domain.MatchResult;
import game.domain.Numbers;
import game.domain.RandomNumbersGenerator;
import game.utils.InputUtil;
import game.utils.OutputUtil;

public class Application {
    public static void main(String[] args) throws Exception {
        do {
            play();
        } while(isOngoing());
    }

    /**
     * This is a method that plays the whole process of the game.
     * The game continues while the number of strikes is not three.
     * @throws Exception
     */
    private static void play() throws Exception {
        Game game = new Game(new RandomNumbersGenerator());
        while(true) {
            Numbers userNumbers = inputNumbers();
            MatchResult result = game.match(userNumbers);
            OutputUtil.showHint(result);
            if(result.isStrokeAll()) {
                break;
            }
        }
        OutputUtil.showFinalResult();
    }

    /**
     * This method is used to re-enter
     * according to the validity of the input value.
     * The recursive case is when the validity exception of Numbers instance occurs.
     * @return Numbers
     */
    private static Numbers inputNumbers() {
        try {
            return Numbers.valueOf(InputUtil.inputNumbers());
        } catch (Exception e) {
            OutputUtil.showError(e);
            return inputNumbers();
        }
    }

    private static boolean isOngoing() {
        return InputUtil.inputIntentionOfReplay() == 1;
    }
}
