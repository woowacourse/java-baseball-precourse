package indi.moon.firstweek;

public interface Computerface {

    /* 랜덤한 수를 담은 배열 생성 */
    public abstract int[] makeRandomNum();

    /* 예외값 탐색 */
    public abstract int exceptEx(int num, int i, int[] tmp);
}
