/**
 * MainClass는 프로그램을 실행하기 위한 main 함수를 포함하는 클래스이다.
 */
public class MainClass {
    /**
     * main 함수는 프로그램 시작 시 호출되는 정작 함수이다.
     * Baseball 객체를 생성하고, playMethod와 exitMethod를 호출해준다.
     *
     * @param args
     */
    public static void main(String[] args){
        Baseball baseball = new Baseball();
        do{
            baseball.playMethod();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 눌러주세요.");
        }while(!baseball.exitMethod());
    }
}
