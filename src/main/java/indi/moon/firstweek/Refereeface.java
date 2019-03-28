package indi.moon.firstweek;

public interface Refereeface {
    public int countStrike(int[][]answer, int[]calledAnswer, String player);
    public int countBall(int[][]answer, int[]calledAnswer, String player);
    public abstract int indexOf(int[] array, int key);
}
