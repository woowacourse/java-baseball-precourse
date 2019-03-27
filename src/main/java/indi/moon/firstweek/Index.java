package indi.moon.firstweek;

import java.lang.annotation.*;
import java.util.Scanner;
public class Index implements Indexface {

    public static void main(String[] args) {

        Index index = new Index();
        Stage stage = new Stage();

        while(true) {
            String commend = index.start();
            if(commend.equals(endCommend)){
                break;
            }else {
                stage.play(commend);
            }
        }
        index.end();
    }

    private static final String endCommend = "exit";

    @Override
    public String start(){
        System.out.println("게임을 시작하려면 아무키나 입력 하세요!\n종료 하려면 exit을 입력하세요.");
        Scanner scan = new Scanner(System.in);
        String commend = scan.nextLine();
        return commend;
    };

    @Override
    public void end(){
        System.out.println("Game End");
    };

}
