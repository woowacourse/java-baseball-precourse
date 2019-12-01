public class MainClass {
    public static void main(String[] args){
        Baseball baseball = new Baseball();
        boolean isEnd = false;
        while(isEnd == false){
            baseball.playMethod();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 눌러주세요.");
            isEnd = baseball.exitMethod();
        }
    }
}
