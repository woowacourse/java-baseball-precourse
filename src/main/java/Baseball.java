import java.util.Scanner;
public class Baseball {

    static int randomdata[] = {0,0,0};
    static int user[] = {0,0,0};
    // 컴퓨터의 랜덤값을 배열에 넣어주는 함수

    static void computeDataInit(int i){
        boolean visit[] = {true,false,false,false,false,false,false,false,false,false,false};
        for(int k=0;k<i;k++) {
            visit[randomdata[k]] = true;
        }
        while(true){
            int temp = (int)(Math.random()*9)+1;
            if(!visit[temp]){
                randomdata[i] = temp;
                break;
            }
        }
    }
    // 유저의 밸류를 배열에 넣어주는 함수
    static void userInit(int n){
        for(int i = 2; i>=0;i--){
            user[i] = n % 10;
            n/=10;
        }
    }

    // 스트라이크를 세는 함수
     static int getStrike(int n){
        int cnt = 0;
        for(int i = 0 ; i<3;i++){
            if(randomdata[i] == user[i])
                cnt++;
        }
        return cnt;
    }

    // 인덱스를 비교하여 볼을 확인하는 함수
    static int ballCompare(int i,int j){
        if(i==j)  // 스트라이크 검사는 생략
            return 0;
        if(randomdata[i] == user[j]) // 같은 수가 있으면 볼
            return 1;
        return 0; // 나머지는 볼이 아니다.
    }
    // 볼카운트를 세는 함수
    static int getBall(int n){
        int cnt = 0;
        for(int i = 0 ; i<3;i++){
            for(int j = 0 ; j<3;j++){
                cnt+= ballCompare(i,j);
            }
        }
        return cnt;
    }

    // 실질적 게임을 작동하는 함수
    static int game(){
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.print("숫자를 입력해주세요 : ");
            int n = sc.nextInt();
            userInit(n);

            int strike = getStrike(n);
            int ball = getBall(n);

            if(strike>0){
                System.out.print(strike);
                System.out.print(" 스트라이크 ");
            }
            if(ball > 0){
                System.out.print(ball);
                System.out.println("볼");
            }
            else{
                System.out.println();
            }

            if(strike == 3){
                break;
            }
        }
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int n = sc.nextInt();
        return n;
    }
    public static void main(String[] args) {
        int n = 1;
        while (n == 1){
            // depth 1
            for(int i =0;i<3;i++) {
                computeDataInit(i);
            }
            n = game();
        }
    }
}
