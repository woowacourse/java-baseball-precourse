import java.util.Random;
import java.util.Scanner;
import java.lang.*;



public class joon_baseball {
    public static void main(String[] args){
        int strike =0;
        int ball =0;
        while(true) {
            Random random = new Random();

            int com[] = new int[3];  //랜덤 컴퓨터 입력
            int me[] = new int[3];   //내가 입력

            //컴퓨터 랜덤으로 3자리 입력, 중복, 0 제거
            while (true) {
                com[0] = random.nextInt(10);
                if (com[0] == 0)
                    continue;
                else
                    break;
            }
            while (true) {
                com[1] = random.nextInt(10);
                if (com[1] == 0 || com[1] == com[0])
                    continue;
                else
                    break;
            }
            while (true) {
                com[2] = random.nextInt(10);
                if (com[2] == 0 || com[2] == com[1] || com[2] == com[0])
                    continue;
                else
                    break;
            }


            Scanner sc = new Scanner(System.in);
            while (true) {
                strike = 0;
                ball = 0;
                String num = "";
                System.out.println("숫자를 입력해주세요 : ");
                //유저의 숫자 입력 받기
                num = sc.nextLine();
                for (int i = 0; i < num.length(); i++) {
                    me[i] = num.charAt(i) - '0';
                }

                //strike,  ball 출력하기
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (com[i] == me[j]) {
                            if (i == j) {
                                strike += 1;
                            } else {
                                ball += 1;
                            }
                        }
                    }
                }
                //결과 출력하기
                if (strike == 0 && ball == 0) {
                    System.out.println("Noting!!");
                } else if (strike == 3) {
                    System.out.println("3스트라이크!!\n");
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                } else if (ball == 0) {
                    System.out.println(+strike + "스트라이크");
                } else if (strike == 0) {
                    System.out.println(+ball + "볼");
                } else {
                    System.out.println(+strike + "스트라이크" + ball + "볼");
                }

            }
            int k=0;
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
            k=sc.nextInt();
            if(k==1)
                continue;
            else
                break;

        }
    }
}
