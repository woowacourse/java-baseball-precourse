package ui;

import game.model.OneSetResult;

/**
 * 야구게임을 진행하기 위한 입출력 방법을 모아놓은 인터페이스.
 *
 * @author delf
 */
public interface BaseballGameInterface {
    /**
     * @return 사용자로부터 문자열을 입력받아 야구 게임에 사용할 <tt>int</tt> 배열을 반환한다
     */
    int[] getInputArray();

    /**
     * @return 사용자로부터 입력에 따라 <tt>true</tt> <tt>false</tt> 를 반환한다.
     */
    boolean getTrueOrFalse();

    /**
     * 게임 결과를 문자열로 출력한다.
     *
     * @param oneSetResult
     * @see OneSetResult
     */
    void presentResult(OneSetResult oneSetResult);
}
