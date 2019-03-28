import java.util.Random;
import java.util.Scanner;

public class Baseball {
    int[] answer = new int[3];
    int[] userNum = new int[3];
    int strike, ball;

    private void setAnswer(){
        Random random = new Random();

        for(int i = 0; i < 3; i ++)
            answer[i] = random.nextInt(9) + 1;

    }
    private void getNumber(){
        Scanner sc = new Scanner(System.in);

        System.out.print("숫자를 입력해주세요: ");
        String tmp = sc.nextLine();
        for(int i = 0; i < 3; i++)
            this.check(tmp.charAt(i) - '0', i);
    }

    public void play(){
        strike = ball = 0;
        this.setAnswer();

        while(true) {
            this.getNumber();

            if (strike == 0 && ball == 0)
                System.out.println("낫싱");
            else if (strike == 0)
                System.out.println(ball + "볼");
            else if (ball == 0)
                System.out.println(strike + "스트라이크");
            else
                System.out.println(strike + "스트라이크" + ball + "볼");

            if (strike == 3)
                break;
        }
    }

    private void check(int userNum, int loc){
        for(int i = 0; i < 3; i++){
            if(answer[i] == userNum && loc == i)
                strike++;
            else if(answer[i] == userNum && loc != i)
                ball++;
        }
    }

    public static void main(String[] args){
        Baseball game = new Baseball();
        Scanner sc = new Scanner(System.in);

        while(true) {
            game.play();
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. ");
            int dec = sc.nextInt();
            if(dec == 1)
                continue;
            else if (dec == 2){
                System.out.println("게임을 종료합니다.");
                break;
            }
            else{
                System.out.println("잘못된 입력입니다");
                break;
            }
        }
    }
}
