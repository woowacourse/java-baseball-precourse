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
    private static boolean rtnHint(Num answer, Num player){
        int strike= 0;
        int ball= 0;
        String rtnMsg=""
                ;
        if(answer.position[0]==player.position[0]){
            strike++;
        }
        if(answer.position[1]==player.position[1]){
            strike++;
        }
        if(answer.position[2]==player.position[2]){
            strike++;
        }
        if(answer.position[0]==player.position[1]||
                answer.position[0]==player.position[2]){
            ball++;
        }
        if(answer.position[1]==player.position[0]||
                answer.position[1]==player.position[2]){
            ball++;
        }
        if(answer.position[2]==player.position[0]||
                answer.position[2]==player.position[1]){
            ball++;
        }

        if(strike > 0){
            rtnMsg=Integer.toString(strike)+" Strike ";
        }
        if(ball > 0){
            rtnMsg+=Integer.toString(ball)+" Ball";
        }
        System.out.println(rtnMsg);
        if (strike==3){
            return true;
        }
        else{
            return false;
        }
    }

    public static void main(String[] args) {
        Num answer = new Num();
        Num player = new Num();
        answer.setRnum();
        player.setVal();
    }

}

