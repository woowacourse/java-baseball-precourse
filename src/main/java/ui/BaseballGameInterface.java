package ui;

import game.model.OneSetResult;

/**
 * @author delf
 */
public interface BaseballGameInterface {
    int[] getInputArray();
    boolean getTrueOrFalse();
    void presentResult(OneSetResult oneSetResult);
}
