import java.util.Random;


public class Computer {
    private int[] comNumArray;
    private int randomNum;

    public Computer() {
        this.comNumArray = new int[3];
    }

    public int[] getComNumArray(){
        return comNumArray;
    }

    public void makeRandomNum(){
        while (true){
            Random ran = new Random();
            this.randomNum = ran.nextInt(989) + 10;
            if(isValid(randomNum)) break;
        }
    }
}
