package baseball;

public class Computer {
    final static int dataLen =3;
    public static int getStrikeNum(int input[], int answer[]) {
        int strike =0;
        for(int i=0; i<dataLen; i++){
            if(input[i] == answer[i]) strike++;
        }
        return strike;
    }
}
