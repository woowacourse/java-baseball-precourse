package indi.moon.firstweek;

public interface Userface {

    /** 유저에게 번호 입력받음*/
    public abstract int[] receiveNum();

    /** 자신의 정답을 결정하여 배열로 리턴 */
    public abstract int[] decideNumber(String num);
}
