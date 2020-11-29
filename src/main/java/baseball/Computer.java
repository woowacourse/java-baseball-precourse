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
    public static int getBallNum(int input[], int answer[]) {
        int ball =0;
        for(int i=0; i<dataLen; i++){
            if(findIdx(input[i], answer) != -1 &&findIdx(input[i], answer) != i){
                ball++;
            }
        }
        return ball;
    }

    public static int findIdx(int target, int arr[]) {
        for(int i=0; i<dataLen; i++){
            if(target == arr[i]) return i;
        }
        return -1;
    }
}
