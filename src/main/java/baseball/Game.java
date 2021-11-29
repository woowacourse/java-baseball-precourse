package baseball;

import java.util.Arrays;

public class Game {

    public static void startGame(){
        String randomNum = Random.random_Num();
        String userNum;
        int countStrike=0;
        int[] result;

        while (countStrike != 3){
            userNum = User.user_Num();
            result = strike_or_ball(randomNum,userNum);
            print_out(result);
            countStrike=result[0];
        }

        if (User.isContinue()){
            startGame();
        }


    }

    public static int[] strike_or_ball(String rand, String user){
        String[] array_rand;
        String[] array_user;

        array_rand=rand.split("");
        array_user=user.split("");

        int strike = 0;
        int ball = 0;

        for (int i=0; i<3; i++){
            if (Arrays.asList(array_rand).contains(array_user[i]) && array_rand[i].equals(array_user[i])){
                strike+=1;
            }
            else if(Arrays.asList(array_rand).contains(array_user[i]) && !array_rand[i].equals(array_user[i])){
                ball+=1;
            }
        }

        int[] answer = {strike,ball};

        return answer;
    }

    public static void print_out(int[] target){
        if (target[0]==3) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

        }
        else if(target[0]>0 && target[1]==0){
            System.out.println(target[0]+"스트라이크");

        }
        else if(target[0]==0 && target[1]>0){
            System.out.println(target[1]+"볼");

        }
        else if(target[0]>0 && target[1]>0){
            System.out.println(target[1]+"볼 "+target[0]+"스트라이크");

        }
        else {
            System.out.println("낫싱");

        }

    }
}
