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

    public boolean isValid(int inputNum){
        comNumArray[0] = inputNum / 100;
        inputNum = inputNum % 100;
        comNumArray[1] = inputNum / 10;
        comNumArray[2] = inputNum % 10;
        if(comNumArray[0] == comNumArray[1] ||
                comNumArray[0] == comNumArray[2] ||
                comNumArray[1] == comNumArray[2])
            return false;
        return true;
    }

    public void showNum(){
        for(int i:comNumArray){
            System.out.print("i: " + i);
        }
        System.out.println();
    }
}
