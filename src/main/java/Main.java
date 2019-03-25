import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String target = NumCreator.getNum();
        Scanner sc = new Scanner(System.in);
        while(true){
            String input = InputResolver.getInput();
            if(AnsChecker.checkAns(input,target)){
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                if(CmdResolver.resolveCmd()) break;
            }
        }
    }
}
