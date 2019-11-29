import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class gameMc {
    private ArrayList comNum;
    private ArrayList userNum;
    private Scanner inputNum;
    private int round=1;
    private int strike,ball;
    private int gameStatus = 3;

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

    public void compare(){
        strike=0;
        ball=0;
        for(int i=0;i<3;i++){
            if(userNum.get(i)==comNum.get(i)){
                strike+=1;
            }
            else if (comNum.contains(userNum.get(i))){
                ball+=1;
            }
        }
    }
    public void result(){
        if(strike == 3){
            System.out.println("3 스트라이크");
            System.out.println("게임종료! 다시하려면 1, 종료하려면 2 를 입력해주세요");
            isEnd();
        }
        else{
            if(strike*ball > 0){
                System.out.println(strike+" 스트라이크 "+ball+" 볼");
            }
            else if(strike == 0 & ball != 0){
                System.out.println(ball+" 볼");
            }
            else if(strike != 0 & ball == 0){
                System.out.println(strike+" 스트라이크");
            }
            else{
                System.out.println("낫싱");
            }
        }
    }
    public void isEnd(){
        Scanner end = new Scanner(System.in);
        String status = end.next();
        setGameStatus(Integer.valueOf(status));
    }
    public void setGameStatus(int x){
        gameStatus = x;
    }

    public int checkStatus() {
        if (gameStatus == 1) {
            setComNum();
            round=1;
            gameStatus = 3;
        }
        else if(gameStatus == 2){
            System.exit(0);
        }
        return gameStatus;
    }
}
