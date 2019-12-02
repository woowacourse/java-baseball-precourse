/*
 * Randeom
 *
 * ver 1.0
 *
 * 2019.11.30
 *
 * CopyRight
 *
 */

public class Random {
    /*
     * 랜덤 값을 생성하는 클래스 입니다.
     * 랜덤 값 생성, 검사 기능을 함수화 시켰습니다.
     */
    public static int create(){ // 랜덤 값을 생성하는 함수입니다.
        int correct = 0;
        for(int i = 0; i < 3; i++){
            correct *= 10;
            double rand = Math.random() * 9; // 난수 생성
            //System.out.println(rand);
            rand ++;
            correct += rand;
        }
        //System.out.println("answer is: " + correct);
        if(verify(correct)){
            return correct;
        }else{
            return create();
        }
    }

    public static Boolean verify(int correct){ // 랜덤 값을 검사하는 함수입니다.
        int correct_Index1 = correct % 10;
        int correct_Index2 = (correct / 10) % 10;
        int correct_Index3 = (correct / 100) % 10;
        if(correct_Index1 == correct_Index2){
            return false;
        }else if(correct_Index2 == correct_Index3){
            return false;
        }else if(correct_Index3 == correct_Index1){
            return false;
        }else{
            return true;
        }
    }

}
