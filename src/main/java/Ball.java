/*
 * Ball
 *
 * ver 1.0
 *
 * 2019.11.30
 *
 * CopyRight
 *
 */

public class Ball {
    /*
     * Ball 값을 생성하는 클래스 입니다.
     * Ball 값 계산, 심층계산, 검증을 함수화 시켰습니다.
     */
    public static int calculateBall(int answer, int correct){ // 전체 ball 값을 계산합니다.
        int ball = 0;
        for(int correct_Index =0; correct_Index < 3; correct_Index++){
            int count_Ball = compareBall(answer, correct, correct_Index);
            if(count_Ball != 0){
                ball += count_Ball;
            }
            correct /= 10;
        }
        return ball;
    }

    public static int compareBall(int answer, int correct, int correct_Index){ // 정답 값에 한 index 값에서의 ball 값을 계산합니다.
        int ball = 0;
        int temp_Correct = correct % 10;
        for(int answer_Index = 0; answer_Index < 3; answer_Index++){
            int temp_Answer = answer % 10;
            if(whereBall(temp_Correct, temp_Answer, correct_Index, answer_Index)){
                ball++;
            }
            answer /= 10;
        }
        return ball;
    }

    public static Boolean whereBall(int temp_Correct, int temp_Answer, int correct_Index, int answer_Index){ // ball 값을 검증합니다.
        if(correct_Index != answer_Index){
            if(temp_Answer == temp_Correct){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

}
