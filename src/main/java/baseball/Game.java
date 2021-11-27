package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Game {
    private static int[] randomAns;
    private static final String ENTER_NUMBER = "숫자를 입력해주세요 : ";
    public static final String End_GAME = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String ASK_RESTART = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public void play() {
        boolean start = true;
        // 재실행 여부
        while(start){
            // 1. 타겟 넘버 생성
            randomAns = createTargetNum();

            //TODO: 최종 제출 때 빼기
            System.out.println(randomAns[0]+""+randomAns[1]+""+randomAns[2]);

            // 2. 유저에게 입력 받기
            // 3. 유저에게 결과 알려주기
            boolean ansCheck = false;
            while(!ansCheck){
                ansCheck = compareToRandomAns(userInputNum());
            }
            start = checkRestart();
        }
    }


    private int[] createTargetNum(){
        int[] randomAns = new int[3];
        boolean[] check = new boolean[10];
        for(int i=0; i<3; i++){
            int num = Randoms.pickNumberInRange(1,9);

            while(check[num]){
                num = Randoms.pickNumberInRange(1,9);
            }

            check[num] = true;
            randomAns[i] = num;
        }
        return randomAns;
    }


    private int[] userInputNum(){
        System.out.print(ENTER_NUMBER);
        String inputStr = Console.readLine();

        // 2-1. 올바른 input 인지 확인하고 int 배열에 숫자 각각 담기
        int[] userInputNumArr = checkUserInputNum(inputStr);

        return userInputNumArr;
    }


    private int[] checkUserInputNum(String inputStr){
        int[] userInputNumArr = new int[3];

        // 길이가 3미만 3초과일 경우
        if(inputStr.length()<3 || inputStr.length()>3) throw new IllegalArgumentException();

        // 숫자로 이루어지지 않았을 경우, 0이 포함 되어 있을 경우
        // TODO: 같은 숫자가 있는 경우
        for(int i=0; i<3; i++){
            if(inputStr.charAt(i)=='0' || !Character.isDigit(inputStr.charAt(i))){
                throw new IllegalArgumentException();
            }
            userInputNumArr[i] = inputStr.charAt(i)-'0';
        }

        return userInputNumArr;
    }


    private boolean compareToRandomAns(int[] userInputNumArr){
        // 같은 수가 같은 자리에 있으면 스트라이크, 다른 자리에 있으면 볼, 같은 수가 전혀 없으면 포볼 또는 낫싱
        int strike=0;
        int ball=0;

        // 타겟넘버 와 유저인풋넘버 비교
        for(int i=0; i<3; i++){
            int num = userInputNumArr[i];

            //TODO: depth 넘어간 것 수정
            for(int j=0; j<3; j++){
                if(num==randomAns[j]){
                    if(i==j){
                        strike++;
                        break;
                    }
                    ball++;
                    break;
                }
            }
        }

        return notifyBallAndStrike(strike,ball);
    }



    private boolean notifyBallAndStrike(int strike, int ball){
        if(strike==3){
            System.out.println("3스트라이크");
            System.out.println(End_GAME);
            return true;
        }

        if(strike>0 && ball>0){
            System.out.println(ball+"볼"+" "+strike+"스트라이크");
            return false;
        }

        if(strike==0 && ball==0){
            System.out.println("낫싱");
            return false;
        }

        if(ball==0){
            System.out.println(strike+"스트라이크");
            return false;
        }

        if(strike==0){
            System.out.println(ball+"볼");
            return false;
        }

        return false;
    }


    private boolean checkRestart(){
        System.out.println(ASK_RESTART);
        String userRestartInput = Console.readLine();
        if(userRestartInput.equals("1")){
            return true;
        }

        if(userRestartInput.equals("2")){
            return false;
        }

        throw new IllegalArgumentException();
    }
}
