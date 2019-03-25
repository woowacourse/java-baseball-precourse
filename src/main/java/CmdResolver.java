import java.util.Scanner;

public class CmdResolver {
    public static boolean resolveCmd(){
        Scanner sc = new Scanner(System.in);
        while (true){
            String cmd = sc.nextLine();
            if(cmd.equals(Cmd.NEWSTART.getNum())){
                return false;
            } else if(cmd.equals(Cmd.EXIT.getNum())){
                return true;
            } else{
                System.out.println("1 또는 2를 입력하세요.");
            }
        }
    }
}
