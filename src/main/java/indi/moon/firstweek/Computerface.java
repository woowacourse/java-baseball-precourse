package indi.moon.firstweek;

public interface Computerface {

    /** 랜덤한 수를 담은 배열 생성 */
    public abstract int[] makeRandomNum();

    public abstract int exceptEx(int num, int i, int[] tmp);
}
