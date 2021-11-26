package utils;

public class Result{

    public boolean printResult(int strike, int ball){
        String result = "";
        boolean end = false;

        if(strike == 3){
            result += "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
            System.out.println(result);
            end = true;
            return end;
        }

        if(ball != 0){
            result += ball+"볼";
        }

        if(strike != 0){
            result += strike+"스트라이크";
        }

        if(ball == 0 && strike == 0){
            result += "낫싱";
        }
        System.out.println(result);
        return end;
    }

}
