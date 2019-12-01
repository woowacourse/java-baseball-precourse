/**
 * Match
 */
public class Match {
    private int[] computer;
    private String user;
    private int strike=0;
    private int ball=0;
    private String result = "";

    public Match(int[] _computer, String _user){
        computer = _computer;
        user = _user;
        comparewhole();
    }

    //한 숫자씩 비교해서 총 스트라이크, 볼 갯수 측정 후 보여주기
    public void comparewhole(){
        for(int i=0; i<user.length(); i++){
            compare(user.charAt(i)-48,i);
        }
        showResult();
    }


    private void showResult() {
        if (strike!=0 && ball!=0){
            result = strike+" 스트라이크 " + ball + " 볼";
        }else if (strike !=0){
            result = strike+" 스트라이크";
        }else if (ball !=0){
            result = ball+" 볼";
        }else{
            result = "낫싱";
        }
        System.out.println(result);
    }
    /**
     * @return the strike
     */
    public int getStrike() {
        return strike;
    }
    //비교하여 strike ball 갯수 측정
    public void compare(int guess, int index) {
        for(int i=0; i<computer.length; i++){
           // System.out.println(computer[i] + "and" + guess);
            if (computer[i]==guess && i==index){
                strike++;
                return;
            }
            if (computer[i]==guess){
                ball++;
                return;
            }
        }
    }
  
}