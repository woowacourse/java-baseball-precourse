package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Game {
    private static Player player = new Player();
    private static int[] randomAns;
    private static final int BEGIN_NUM = 1;
    private static final int END_NUM = 9;
    private static final int NUM_LENGTH = 3;
    private static final String ENTER_NUMBER = "숫자를 입력해주세요 : ";
    public static final String End_GAME = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String ASK_RESTART = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";
    private static final  String NOTHING = "낫싱";

    public void play() {
        boolean start = true;

        while(start){
            randomAns = createTargetNum();

            //TODO: 최종 제출 때 빼기
            System.out.println(randomAns[0]+""+randomAns[1]+""+randomAns[2]);

            boolean ansCheck = false;
            while(!ansCheck){
                ansCheck = compareToRandomAns(userInputNum());
            }
            start = checkRestart();
        }
    }


    private int[] createTargetNum(){
        int[] randomAns = new int[3];
        boolean[] check = new boolean[END_NUM+1];

        for(int i=0; i<NUM_LENGTH; i++){
            int num = Randoms.pickNumberInRange(BEGIN_NUM,END_NUM);

            while(check[num]){
                num = Randoms.pickNumberInRange(BEGIN_NUM,END_NUM);
            }

            check[num] = true;
            randomAns[i] = num;
        }
        return randomAns;
    }


    private int[] userInputNum(){
        System.out.print(ENTER_NUMBER);
        String inputStr = Console.readLine();

        return checkUserInputNum(inputStr);
    }


    private int[] checkUserInputNum(String inputStr){
        int[] userInputNumArr = new int[NUM_LENGTH];
        boolean[] checkInputNum = new boolean[END_NUM+1];

        // 입력 값이 길이가 3미만 3초과일 경우
        if(inputStr.length()<NUM_LENGTH || inputStr.length()>NUM_LENGTH) throw new IllegalArgumentException();

        // 숫자로 이루어지지 않았을 경우, 0이 포함 되어 있을 경우, 반복된 숫자를 입력하였을 경우
        for(int i=0; i<NUM_LENGTH; i++){
            int inputNum = inputStr.charAt(i)-'0';
            if(inputStr.charAt(i)=='0' || !Character.isDigit(inputStr.charAt(i))){
                throw new IllegalArgumentException();
            }

            if(checkInputNum[inputNum]){
                throw new IllegalArgumentException();
            }

            checkInputNum[inputNum] = true;
            userInputNumArr[i] = inputStr.charAt(i)-'0';
        }

        return userInputNumArr;
    }

    private boolean compareToRandomAns(int[] userInputNumArr){
        player.init(userInputNumArr);

        for(int i=0; i<NUM_LENGTH; i++){
            player.compareNum(randomAns[i],i);
        }

        return notifyBallAndStrike(player.getStrike(), player.getBall());
    }

    private boolean notifyBallAndStrike(int strike, int ball){
        if(strike==3){
            System.out.println(NUM_LENGTH+STRIKE);
            System.out.println(End_GAME);
            return true;
        }

        if(strike>0 && ball>0){
            System.out.println(ball+BALL+" "+strike+STRIKE);
            return false;
        }

        if(strike==0 && ball==0){
            System.out.println(NOTHING);
            return false;
        }

        if(ball==0){
            System.out.println(strike+STRIKE);
            return false;
        }

        if(strike==0){
            System.out.println(ball+BALL);
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
