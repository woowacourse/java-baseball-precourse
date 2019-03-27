package indi.moon.firstweek;

public interface Refereeface {
    public abstract int countStrike(int[]answer, int[]calledAnswer);
    public abstract int countBall(int[]answer, int[]calledAnswer);
    public abstract int indexOf(int[] array, int key);
}
