import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class gameMc {
    private ArrayList comNum;
    private ArrayList userNum;
    private Scanner inputNum;
    private int round=1;

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

    public void setUserNum(){
        try{
            System.out.println("-------"+round+"round--------");
            this.userNum = new ArrayList();
            System.out.println("서로다른 3자리 숫자를 입력해주세요 : ");
            inputNum = new Scanner(System.in);
            String temp = inputNum.next();
            String[] arrayTemp = temp.split("");
            for(int i=0;i<3;i++){
                this.userNum.add(Integer.valueOf(arrayTemp[i]));
            }
            round+=1;
        }catch(Exception e){
            System.out.println("3자리 숫자만 입력 해주세요");
            setUserNum();
        }

    }
    public void getUserNum(){
        System.out.println("userNum : "+this.userNum);
    }
}
