package indi.moon.firstweek;

public interface Stageface {

    /** 실질적으로 singlePlay 게임이 진행되는 메소드 */
    public abstract void singlePlay();

    /** 실질적으로 multiPlay 게임이 진행되는 메소드 */
    public abstract void multiPlay();

    /** 답을 체크하고 스트라이크와 볼의 갯수 리턴 */
    public abstract int[] check(int[] answer,int[] myAnswer);

    /** check의 리턴값을 문자열로 리턴 */
    public abstract String checkLog(int[] result);
}
