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

    // 실질적 게임을 작동하는 함수
    static int game(){
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("숫자를 입력해주세요 : ");
            int n = sc.nextInt();
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
