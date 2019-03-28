package indi.moon.firstweek;

public interface Refereeface {
    /* 스트라이크의 갯수를 확인 */
    public int countStrike(int[][]answer, int[]calledAnswer, String player);

    /* 볼의 갯수를 확인 */
    public int countBall(int[][]answer, int[]calledAnswer, String player);

    /* 배열의 값 찾기 */
    public abstract int indexOf(int[] array, int key);
}
