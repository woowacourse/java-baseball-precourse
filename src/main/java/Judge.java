public class Judge {
    /*
     *  Judge.java
     *
     *  ver 1.0.4
     *
     *  2019/03/28
     *
     */
    protected int strike = 0;
    protected int ball = 0;

    public void count(int[] userNum, int[] comNum){
        for (int i = 0; i < 3; ++i){
            compare(i, userNum, comNum);
        }
    }
    public void compare(int i, int[] userNum, int[] comNum){
        for (int j = 0; j < 3; ++j){
            if ((userNum[i] == comNum[j]) && (i == j)){
                this.strike++;
                break;
            }
            if (userNum[i] == comNum[j]){
                this.ball++;
                break;
            }
        }
    }
    public void printResult(){
        if (this.ball == 0){
            System.out.println(this.strike + "스트라이크");
        }
        else if (this.strike == 0){
            System.out.println(this.ball + "볼");
        }
        else{
            System.out.println(this.strike + "스트라이크 " + this.ball + "볼");
        }
    }
}
