package baseball;

public class Judge {
    private static char[] defendNumber;
    public static boolean flag;

    private Judge(){ }

    public static Judge passNumberToJudge(String number) {
        defendNumber = number.toCharArray();
        flag = false;
        return new Judge();
    }

    public String judging(String attackNumber){
        if(attackNumber.length()!=3 || attackNumber.contains("0")) {
            throw new IllegalArgumentException();
        }
        char[] a =attackNumber.toCharArray();
        int strike=0;
        int ball=0;
        for(int i=0; i<3; i++){
            if(defendNumber[i]==a[i])strike++;
            else {
                if (attackNumber.contains(defendNumber[i] + "")) {
                    ball++;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        if (ball == 0 && strike == 0) {
            sb.append("낫싱");
        } else {
            if (ball> 0) {
                sb.append(ball + "볼 ");
            }
            if (strike> 0) {
                if(strike==3) flag=true;
                sb.append(strike + "스트라이크");
            }
        }

        return sb.toString();
    }

}
