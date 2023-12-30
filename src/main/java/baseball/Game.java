package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Game {

    public List<Integer> getUserNum(){
        System.out.print("숫자를 입력해주세요 : ");
        String user = readLine();

        isLength(user);
        isDuplicate(user);
        List<Integer> userNum = isRange(user);

        return userNum;
    }

    //(1) [유저] 예외처리 - 3개가 아닌경우
    public static void isLength(String num){
        if(num.length() != 3){
            throw new IllegalArgumentException("3개의 숫자가 아닙니다.");
        }
    }

    //(2) [유저] 예외처리 - 중복되는 숫자가 있을 경우
    public static void isDuplicate(String num) {
        Set<Character> set = new HashSet<>();

        for(int i = 0; i < num.length(); i++){
            set.add(num.charAt(i));
        }

        if(set.size() != num.length()){
            throw new IllegalArgumentException("중복되는 숫자를 입력했습니다.");
        }
    }

    //(3) [유저] 예외처리 - 1~9가 아닐 경우
    public List<Integer> isRange(String num){
        List<Integer>userNum = new ArrayList<>();

        for(int i = 0; i <3; i++){
            int intNum = num.charAt(i) - '0';

            if(intNum >= 1 && intNum <= 9){
                userNum.add(intNum);
            } else {
                throw new IllegalArgumentException("1~9 범위의 숫자가 아닙니다.");
            }
        }
        return userNum;
    }

    public List<Integer> getComputerNum(){
        List<Integer> computerNum = new ArrayList<>();
        for(int i = 0; i < 3; i++){
            int randomNumber = Randoms.pickNumberInRange(1,9);

            //(1) [컴퓨터] 예외처리 - 중복된 숫자가 안들어가도록
            if(!computerNum.contains(randomNumber)) {
                computerNum.add(randomNumber);
            } else {
                throw new IllegalArgumentException("중복되는 숫자가 나왔습니다.");
            }
        }
        return  computerNum;
    }

    public void playGame() {
        List<Integer> computerNum = getComputerNum();

        while(true){
            System.out.println("컴퓨터 숫자 : "+ computerNum.get(0)+computerNum.get(1)+computerNum.get(2));
            List<Integer> userNum = getUserNum();

            int strike = checkStrike(computerNum, userNum);
            int ball = checkBall(computerNum, userNum) - strike;
            int play = checkResult(strike, ball);

            if (play == 2){
                break;
            }
        }
    }

    public Integer checkBall(List<Integer> computerNum, List<Integer> userNum){
        int ball = 0;

        for(int i = 0; i < 3; i++){
            if(computerNum.contains(userNum.get(i))){
                ball++;
            }
        }
        return ball;
    }

    public Integer checkStrike(List<Integer> computerNum, List<Integer> userNum){
        int strike = 0;

        for(int i = 0; i < 3; i++){
            if(computerNum.get(i) == userNum.get(i)){
                strike++;
            }
        }
        return strike;
    }

    public Integer checkResult(Integer strike, Integer ball){

        if(strike == 0 && ball == 0){
            System.out.println("낫싱");
        } else if (strike != 0 && ball != 0) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        } else if (strike == 0 && ball != 0){
            System.out.println(ball + "볼");
        } else if (strike < 3){
            System.out.println(strike + "스트라이크");
        } else {
            System.out.println(strike + "스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" + "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            return 2;
        }
        return 1;
    }

    public Integer retryGame() {
        String checkPlay = readLine();
        int checkPlayNum = Integer.parseInt(checkPlay);

        //(1) 예외처리 1또는 2가 아닌경우
        if(checkPlayNum == 1 || checkPlayNum == 2){
            return checkPlayNum;
        } else {
            throw new IllegalArgumentException("1 또는 2를 입력하지 않았습니다.");
        }
    }
}
