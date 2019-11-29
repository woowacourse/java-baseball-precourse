import java.util.Scanner;

class Num{
    int val=0;
    int[] position = new int[3];
    Scanner sc = new Scanner(System.in);

    /// 난수가 100보다 크고, 각 자리에 해당하는 수가 중복되지 않을때 까지 난수 생성
    public void setRnum(){
        while (this.val<100||
                this.position[0]==this.position[1]||
                this.position[0]==this.position[2]||
                this.position[1]==this.position[2]){
            this.val = (int)(Math.random()*1000);
            this.setPosition();
        }
    }

    public void setVal(){
        System.out.println("type your answer : ");
        this.val=this.sc.nextInt();
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
        String rtnMsg="";
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
        if(strike==0&&ball==0){
            rtnMsg="헛스윙";
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
        Scanner sc = new Scanner(System.in);
        Boolean gameKey = true;
        Num player = new Num();
        while(gameKey==true){
            Num answer = new Num();
            answer.setRnum();
            Boolean stageKey = false;
            while(stageKey==false){
                player.setVal();
                stageKey=rtnHint(answer,player);
            }
            System.out.println("Stage finished");
            System.out.println("press 1 to restart, 2 to exit");
            if(sc.nextInt()==2) {
                gameKey = false;
                System.out.println("Game Over");
            }
        }
    }
}