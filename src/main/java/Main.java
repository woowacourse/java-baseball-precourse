public class Main {
    static int ComputerNumber[];
    static int UserNumber[];
    static Computer computer ;
    static User user;

    public static void main(String[] args) {
        manager();
    }

    private static void init() {
        computer = new Computer();
        ComputerNumber = new int[3];
        user = new User();
        UserNumber = new int[3];
        getComputerNumber();
    }

    private static void manager() {
        init();
        System.out.println(ComputerNumber[0]+"/"+ComputerNumber[1]+"/"+ComputerNumber[2]);
        boolean check =false;
        while(!check){
            getUserNumber();
            check = getResult();
        }
    }

    private static boolean getResult() {
        int Strike =0, Ball=0;
        if(ComputerNumber[0] == UserNumber[0]) Strike++;
        if(ComputerNumber[1] == UserNumber[1]) Strike++;
        if(ComputerNumber[2] == UserNumber[2]) Strike++;
        if(ComputerNumber[0] != UserNumber[0] && ( ComputerNumber[0] == UserNumber[1] || ComputerNumber[0] == UserNumber[2])) Ball++;
        if(ComputerNumber[1] != UserNumber[1] && ( ComputerNumber[1] == UserNumber[0] || ComputerNumber[1] == UserNumber[2])) Ball++;
        if(ComputerNumber[2] != UserNumber[2] && ( ComputerNumber[2] == UserNumber[0] || ComputerNumber[2] == UserNumber[1])) Ball++;

        if(Strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
            int userselect = user.setendGame();
            gameState(userselect);
            return true;
        }
        if(Strike>0) {

            System.out.print(Strike+" 스트라이크 ");
        }
        if(Ball>0) {
            System.out.print(Ball+" 볼");
        }
        if(Strike==0 && Ball==0){
            System.out.print("낫싱!");
        }
        System.out.println();
        return false;
    }

    private static void gameState(int userselect) {
        if(userselect == 1) {
            manager();
        }else if(userselect == 2) {
            System.out.println("게임을 완전히 종료합니다.");
        }
    }

    private static void getComputerNumber() {
        computer.setRandomNumber();
        ComputerNumber = computer.getRandomNumber();
    }

    private static void getUserNumber(){
        user.setUserNumber();
        UserNumber = user.getUserNumber();
    }



}