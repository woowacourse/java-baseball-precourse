
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
        Game game = new Game(new RandomNumbersGenerator());
        Numbers userNumbers = inputNumbers();
        MatchResult result = game.match(userNumbers);
        OutputUtil.showHint(result);
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
}
