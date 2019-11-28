import java.util.Scanner;

class Num{
    int val=0;

    public void setRnum(){
        while (this.val<100){
            this.val = (int)(Math.random()*1000);
        }
    }
    public void setVal(){
        System.out.println("type your answer : ");
        Scanner sc = new Scanner(System.in);
        this.val=sc.nextInt();
    }
}



public class NumberBaseball {

    public static void main(String[] args) {
        Num answer = new Num();
        Num player = new Num();
        answer.setRnum();
        player.setVal();
        System.out.println(answer.val);
        System.out.println(player.val);
    }

}
