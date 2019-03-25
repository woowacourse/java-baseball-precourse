import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while(true){
            String target = NumCreator.getNum();
            AnsChecker.compareWith(target);
            if(CmdResolver.resolveCmd()) break;
        }
    }
}
