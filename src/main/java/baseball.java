import java.util.Scanner;
import java.util.Random;

public class baseball{

    public static int match_check(int answer, int input){
        int strike = 0;
        int ball = 0;
        int ans[] = new int[4];
        int inp[] = new int[4];
        for(int i=1; i<=3; i++){
            ans[i] = answer%10;
            inp[i] = input%10;
            answer /= 10;
            input /= 10;
        }
        for(int i=1; i<=3; i++){
            int comp = baseball.find_pos(ans, inp[i]);
            strike += (comp==i? 1:0);
            ball += (comp!=i && comp!=-1? 1:0);
        }
        if(strike==3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return 0;
        }
        if(strike==0 && ball==0)
            System.out.print("낫싱");
        if(strike>0)
            System.out.print(strike + " 스트라이크 ");
        if(ball>0)
            System.out.print(ball + " 볼");
        System.out.println();
        return 1;
    }
    public static int makeanswer(){
        int check_dup[] = {1, 0, 0, 0, 0, 0, 0, 0, 0, 0}; // 서로 다른 세 자리수를 고르기 위해 중복 체크
        int answer=0;
        for(int i=1; i<=3; i++){
            int randnum = baseball.getrand(check_dup); // check_dup 배열을 기준으로 중복되지 않은 숫자를 하나 생성.
            answer = answer*10 + randnum; // 현재까지 나온 결과값에 추가.
            check_dup[randnum]=1; // 방금 추가된 숫자의 사용 여부를 체크.
        }
        return answer;
    }
    public static void baseball_game(){
        int answer, state=1;
        answer = baseball.makeanswer(); // 컴퓨터의 정답
        System.out.println("난수 생성 완료.");
        Scanner scan = new Scanner(System.in);
        while(state==1) {
            int input;
            System.out.print("숫자를 입력해주세요 : ");
            input = scan.nextInt();
            state = baseball.match_check(answer, input);
        }
    }
    public static void main(String[] args){
        int keep_going = 1;
        Scanner scan = new Scanner(System.in);
        do{
            baseball.baseball_game();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            keep_going = scan.nextInt();
        } while(keep_going==1);

    }
}