/**
 * DIsplay 클래스는 baseballGame에 필요한 문구를 출력하는 클래스 입니다.
 *
 * @version         1.0 2019년 3월 25일
 * @author          이중혁
 */
public class Display {

    /* 사용자 입력을 요구하는 문구를 출력하는 메소드 */
    public static void inputDisplay() {

        System.out.print("숫자를 입력해주세요 : ");  // 사용자 입력 문구 출력
    }

    /*비교 결과 출력, 비교 결과가 저장되있는 배열을 매개변수로 받는다*/
    public static void matchDisplay(int[] baseballResult){

        if((baseballResult[0] == 0) && (baseballResult[1] == 0)){

            /* 0스트라이크 0볼 일때 */
            System.out.println(" ");

        } else if((baseballResult[0] != 0) && (baseballResult[1] == 0)){

            /* 1스트라이크 이상  0볼 일때 */
            System.out.println(baseballResult[0] + " 스트라이크");

        } else if ((baseballResult[0] == 0) && (baseballResult[1] != 0)) {

            /* 0스트라이크 1볼 이상 일때 */
            System.out.println(baseballResult[1] + " 볼");

        } else if((baseballResult[0] != 0) && (baseballResult[1]) != 0){

            /* 1스트라이크 이상 1볼 이상 일때 */
            System.out.println(baseballResult[0] + " 스트라이크" + baseballResult[1] + " 볼");

        }

    }

    /* 3스트라이크 일경우 게임 종료 문구 출력 */
    public static void getResultDisplay(int[] baseballResult){

        if(baseballResult[0] == 3){

            /* 3스트라이크일 때 */
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
        }
    }


}
