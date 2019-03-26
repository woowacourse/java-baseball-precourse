import java.util.*;

/**
 * @version 1.00 2019년 3월 28일까지
 * @author hoonha
 */

public class baseball {

    /* 숫자 자릿수 선언 */
    private static final int DIGIT = 3;

    /* 사용자 입력 변수 선언 */
    private static String user_Number = "";

    /* 중복 숫자를 줄이는 방법 LinkedHashSet 사용 입력 순서로 추가 */
    private static Set<String> com = new LinkedHashSet<>();

    /* 컴퓨터 Set 숫자를 저장할 배열 */
    private static String[] com_Array = new String[DIGIT];

    /* 사용사 숫자 저장하는 배열 */
    private static String[] user_Array = new String[DIGIT];

    /* 스트라이크 볼 생성 */
    private static int strike = 0;
    private static int ball = 0;

    /* 게임 재시작 변수 */
    private static boolean selector = true;

    /* 컴퓨터 임의의 3자리의 수를 선택하는 메소드 */
    private static void com_Create_Number(){
        Random rand = new Random();

        /* 숫자가 중복되어도 3자리 숫자를 생성 */
        for (int i = 0; com.size() < DIGIT; i++){
            com.add(String.valueOf(rand.nextInt(9)+1));
        }
    }

    /* 임의의 숫자 3자리를 배열에 저장 메소드 */
    private static void getCom_Array(){
        com_Create_Number();
        Iterator<String> iterator = com.iterator();
        /* 컴퓨터 임의의 수를 배열에 넣기 위한 변수 */
        int k= 0;

        while(iterator.hasNext()){
            com_Array[k++] = iterator.next();
        }
    }

    /* 사용자 숫자 입력 메소드*/
    private static void getUser_Input_Number(){
        Scanner sc = new Scanner(System.in);

        System.out.println("숫자를 입력해주세요 : ");
        user_Number =  sc.nextLine();

        user_Array = user_Number.split("");

    }

    /* 스트라이크 체크 메소드 */
    private static void check_Staike(){
        for (int i = 0; i<DIGIT; i++){
            if (com_Array[i].equals(user_Array[i])) {
                strike++;
            }
        }
    }

    /** 볼 체크 메소드
     *  배열위치의 값이 일치 하지 않아야 함
     *  Arrays.asList 배열을 리스트로 반환
     *  contains 메서드 통해 컴퓨터리스트와 유저 배열 포함 판별
     *  */
    private static void check_Ball(){

        for (int i = 0; i < DIGIT; i++) {
            if ((!com_Array[i].equals(user_Array[i])) &&
                    (Arrays.asList(com_Array).contains(user_Array[i]))) {
                ball++;
            }
        }
    }

    /* 숫자야구 게임 진행 메소드 */
    private static void process(){

        getCom_Array();

        /*컴퓨터 숫자 출력*/
        //for (int i = 0; i < DIGIT; i++) System.out.println(com_Array[i]);

        getUser_Input_Number();
        check_Staike();
        check_Ball();

    }

    /* 게임 결과 프로세스 메소드 */
    private static void game_Result_Process() {

        if (strike == DIGIT){
            System.out.println(DIGIT+"개의 숫자를 모두 맞히셨습니다! 게임 종료");
            game_Restart_Select();

        } else if ((strike | ball) > 0){
            score_Reset();

        } else if ((strike & ball) == 0) {
            System.out.println("낫싱");

        } else {
            score_Reset();
        }
    }

    /* 게임 재시작 메소드 */
    private static boolean game_Restart_Select() {
        Scanner scan = new Scanner(System.in);
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int choice = scan.nextInt();

        if (choice == 1 ) {
            com_Number_Reset();
            score_Reset();
            return true;

        } else if (choice == 2) {
            return selector = false;

        } else {
            System.out.println("다시 입력하세요");
            return game_Restart_Select();
        }
    }

    /**
     * 컴퓨터 숫자 초기화 메소드
     * Iterator 인터페이스 통해 Set 클래스 순회 및 제거
     * */
    private static void com_Number_Reset(){
        for (Iterator<String> iterator = com.iterator(); iterator.hasNext();) {
            iterator.next();
            iterator.remove();
        }
    }

    /* 스트라이크, 볼 초기화 메소드 */
    private static void score_Reset(){
        strike=0;
        ball=0;
    }

    /* 사용자 문자열 초기화 메소드 */
    private static void user_Number_Reset(){
        user_Number = "";
    }


    /* 숫자야구게임 시작 메소드 */
    private static void start(){
        while (selector) {
            process();
        }
    }


    public static void main(String[] args){

    }
}

