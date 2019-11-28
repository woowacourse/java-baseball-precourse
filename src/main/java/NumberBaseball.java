import java.util.Scanner;

class Num{
    int val=0;
    int[] position = new int[3];

    public void setRnum(){
        while (this.val<100){
            this.val = (int)(Math.random()*1000);
        }
        this.setPosition();
    }

    public void setVal(){
        System.out.println("type your answer : ");
        Scanner sc = new Scanner(System.in);
        this.val=sc.nextInt();
        this.setPosition();
    }
    private void setPosition(){
        this.position[0] = this.val/100;
        this.position[1] = this.val%100/10;
        this.position[2] = this.val%10;
    }


}

public class NumberBaseball {

    public static void main(String[] args) {
        Num answer = new Num();
        Num player = new Num();
        answer.setRnum();
        player.setVal();
    }

}

