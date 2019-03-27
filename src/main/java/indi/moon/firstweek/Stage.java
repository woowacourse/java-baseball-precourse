package indi.moon.firstweek;

public class Stage implements Stageface {

    User user = new User();

    @Override
    public void play(String commend) {
        System.out.println("게임이 시작되었습니다.");

    }

    @Override
    public int[] check(int[][] answer,int[] myAnswer){
        int[] a = {0};
        return a;
    }

    @Override
    public String checkLog(int[] result){
        String log = "로그";
        return log;
    }
}