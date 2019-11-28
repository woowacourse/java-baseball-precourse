import java.lang.*;

public class Pitcher {
    private static final int PITCHING_COUNT = 3;
    private int[] pitching;

    public Pitcher(){
        pitching = new int[PITCHING_COUNT];

        for(int i=0;i<PITCHING_COUNT;i++){
            pitching[i] = (int)(Math.random()*10 -1);
        }
    }
    public void setPitching(int a){
        if(a<100 || a>=1000)    return;
        for(int i=0;i<PITCHING_COUNT;i++){
            int tmp = a%10;
            pitching[i] = tmp;
            a/=10;
        }
    }
    public void printPitching(){
        for(int i=0;i<PITCHING_COUNT;i++){
            System.out.println(pitching[i]);
        }
    }
}
