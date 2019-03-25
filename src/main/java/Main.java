import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String target = NumCreator.getNum();
        Scanner sc = new Scanner(System.in);
        while(true){
            String input = InputResolver.getInput();
            AnsChecker.checkAns(input,target);
            if(CmdResolver.resolveCmd()) break;
        }
    }
}
