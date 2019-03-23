import java.util.Scanner;

public class Baseball {
    private int userNumA;
    private int userNumB;
    private int userNumC;
    private int strike = 0;

    public void setInputNum(){
        Scanner sc = new Scanner(System.in);
        System.out.print("숫자를 입력해주세요 : ");
        int userNum = sc.nextInt();
        if(userNum < 123 || userNum > 987) {
            System.out.println("잘못된 입력값 입니다!!");
            setInputNum();
        }else{
            setDivUserNum(userNum);
        }
    }

    public void setDivUserNum(int num){
        int a = num/100, b = (num - (a*100))/10, c = num - ((a*100) + (b*10));
        if(isCorrectNum(a, b, c)){
            setUserNumA(a);
            setUserNumB(b);
            setUserNumC(c);
        }else{
            System.out.println("잘못된 입력값 입니다!!");
            setInputNum();
        }
    }

    public boolean isCorrectNum(int a, int b, int c){
        if(a == 0 || b == 0 || c == 0 || a == b || a == c || b == c) return false;
        else return true;
    }

    public void setCheckStrike(RandomNumber rn){
        resetStrike();
        if(rn.getRandA() == this.userNumA) setUpStrike();
        if(rn.getRandB() == this.userNumB) setUpStrike();
        if(rn.getRandC() == this.userNumC) setUpStrike();
    }
    public void resetStrike(){ this.strike = 0; }
    public void setUpStrike(){ this.strike += 1; }

    public void setUserNumA(int n){ this.userNumA = n; }
    public void setUserNumB(int n){ this.userNumB = n; }
    public void setUserNumC(int n){ this.userNumC = n; }

}
