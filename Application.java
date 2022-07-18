package baseball;
import camp.nextstep.edu.missionutils.test.Randoms;
import camp.nextstep.edu.missionutils.test.Console;


public class Application {
    public static void main(String[] args) {
        Computer computer = new Computer();
        Player player = new Player();
        boolean gameover = true;
        Again again = new Again();
        Judging judge = new Judging();
        while(gameover){
            List<Integer> ComputerNumber = computer.computerNum();
            String answer = "";
            while(answer != "3스트라이크"){
                answer = judge.Result(ComputerNumber, player.PlayerNum());
                System.out.println(answer);
            }
            gameover = again.doitagain();
        }


    }
}


public class Computer{
    public int computerNum{
        List<Integer>  randomNum = new ArrayList<>();
        while (randomNum.size()<3) {
            int num = Randoms.pickNumberInRange(1,9);
            if (!randomNum.contains(num)) {
                randomNum,add(num);
            }
        }
        return randomNum;
    }
}


public class Player{
    public int PlayerNum(){
        System.out.println("숫자를 입력하세요: ");
        String input = Console.readLine();
        List<Integer> playerNum = new ArrayList<Integer>(3);
        try {
            for (String number : input) {
                playerNum.add(Integer.parseInt(number));
            }
        } catch (IllegalArgumentException e) {
            System.out.println("입력이 올바르지 않습니다.");
        }
        return playerNum;
    }
}


public class Guessing{
    public int Strikes(List<Integer> computerNum, List<Integer> playerNum){
        int strike = 0;
        for(int i = 0; i < 3; i++){
            if(computerNum[i] = playerNum[i]){
                strike+=1;
            }
        }
        return strike
    }
    public int TotalCounts(List<Integer> computerNum, List<Integer> playerNum){
        int total = 0;
        for(int i = 0;i < 3; i++){
            if(computerNum.contains(playerNum[i])){
                total += 1;
            }
        }
        return total;
    }
}


public class Judging{
    Guessing guess = new Guessing;
    public String Result(List<Integer> computerNum, List<Integer> playerNum){
        int strike = guess.Strikes(computerNum, playerNum);
        int total = guess.TotalCounts(computerNum, playerNum);
        int ball = total - strike;
        if (strike == 3){
            return "3스트라이크";
        }
        else if (total == 0){
            return "낫싱";
        }
        else if (strike == 0){
            return ball + "볼";
        }
        else if (ball == 0){
            return stirke + "스트라이크";
        }
        return ball + "볼 " + strike + "스트라이크";
    }
}


public class Again{
    public boolean doitagain(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        Syste.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int again = Console.readLine();
        if (again == 1){
           return true;
        }
        else{
            return false;
        }
    }
}