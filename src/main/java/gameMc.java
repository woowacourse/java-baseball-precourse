import java.util.ArrayList;
import java.util.Random;

public class gameMc {
    private ArrayList comNum;


    public gameMc(){
        setComNum();
    }

    public void setComNum(){
        this.comNum = new ArrayList();
        Random rand = new Random();
        while (this.comNum.size()<3) {
            int x = rand.nextInt(9);
            if (x != 0 & !this.comNum.contains(x)) {
                this.comNum.add(x);
            }
        }
    }
    public void getComNum(){
        System.out.println("comNum : "+this.comNum);
    }
}
