/*
 * Strike
 *
 * ver 1.0
 *
 * 2019.11.30
 *
 * CopyRight
 *
 */

public class Strike {
    /*
     * strike 값을 생성하는 클래스 입니다.
     * strike 값 계산, 검증을 함수화 시켰습니다.
     */
    public static int calculateStrike(int answer, int correct){ // strike값을 계산합니다.
        int strike = 0;
        for(int i =0; i < 3; i++){
            if(compareStrike(answer, correct)){
                strike++;
            }
            answer /= 10;
            correct /= 10;
        }
        return strike;
    }

    public static Boolean compareStrike(int answer, int correct){ // strike 값을 검증합니다
        int temp_Correct = correct % 10;
        int temp_Answer = answer % 10;
        if(temp_Answer == temp_Correct){
            return true;
        }else{
            return false;
        }
    }

}
