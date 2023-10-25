package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import static camp.nextstep.edu.missionutils.Console.readLine;
import java.util.ArrayList;
import java.util.List;

public class Game {

    public List<Integer> GetUser(){
        System.out.print("숫자를 입력해주세요 : ");
        String inputString = readLine();

        if(inputString.length()>=4){
            throw new IllegalArgumentException();
        }

        int intValue;

        try {
            intValue = Integer.parseInt(inputString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        if (intValue <= 1 && intValue <= 9) {
            throw new IllegalArgumentException();
        }




        List<Integer> user = new ArrayList<>();

        for (int i=0; i<inputString.length(); i++) {
            user.add(inputString.charAt(i)-'0');
        }

        return user;
    }

    public List<Integer> GetComputer(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return computer;
    }

    public List<Integer> checkResult(List<Integer> user, List<Integer> computer){
        List<Integer> result = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        for (int i=0; i<3; i++) {
            tmp.add(computer.get(i));
        }
        int strike=0;
        int ball=0;
        //같은자리에 같은숫자 = S, 다른자리에 같은 숫자 = B;

        for (int i=0; i<3; i++) {
            if (user.get(i) == tmp.get(i)) {
                strike += 1;
            }
        }

        for (int i=0; i<3; i++) {
            if (user.get(0) == tmp.get(i)) {
                ball += 1;
                tmp.set(i,0);
                continue;
            }
            if (user.get(1) == tmp.get(i)) {
                ball += 1;
                tmp.set(i,0);
                continue;
            }
            if (user.get(2) == tmp.get(i)) {
                ball += 1;
                tmp.set(i,0);
                continue;
            }
        }

        result.add(strike);
        result.add(ball-strike);
        return result;
    }

    public int printResult(List<Integer> result){
        if(result.get(0) == 3){
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String exitcode = readLine();

            int intValue;
            try {
                intValue = Integer.parseInt(exitcode);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException();
            }

            if (intValue != 1 && intValue != 2) {
                throw new IllegalArgumentException();
            }

            if(intValue == 2){
                return 2;
            }
            else{
                return 3;
            }
        }
        else if(result.get(0)==0 && result.get(1) == 0){
            System.out.println("낫싱");
        }
        else if(result.get(0) !=0 && result.get(1) == 0){
            System.out.printf("%d스트라이크",result.get(0));
            System.out.println();
        }
        else if(result.get(0)==0 && result.get(1) != 0){
            System.out.printf("%d볼",result.get(1));
            System.out.println();
        }
        else{
            System.out.printf("%d볼 %d스트라이크",result.get(0), result.get(1));
            System.out.println();
        }

        return 1;
    }
    public void playGame(){
        Game game = new Game();
        List<Integer> computer = game.GetComputer();
        List<Integer> user = game.GetUser();
        int flag;
        while(true){
            flag = printResult(game.checkResult(user,computer));
            if(flag==1){
                user = game.GetUser();
            }
            else if(flag==3){
                computer = game.GetComputer();
                user = game.GetUser();
            }
            else{
                break;
            }
        }
    }
}
