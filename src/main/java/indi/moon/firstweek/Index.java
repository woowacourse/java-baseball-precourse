package indi.moon.firstweek;

import java.lang.annotation.*;
import java.util.Scanner;
public class Index implements Indexface {

    private static final String END_COMMAND = "exit";
    private static final String SINGLE_COMMAND = "1";
    private static final String MULTI_COMMAND = "2";

    public static void main(String[] args) {

        Index index = new Index();
        Stage stage = new Stage();
        Boolean state = true;
        while(state) {
            System.out.println("singlePlay시에 1을 입력 하세요.\nMultiPlay시에 2를 입력하세요\n종료 하려면 exit을 입력하세요.");
            String commend = index.start();
            state = selectType(stage,commend,state);
        }
        index.end();
    }

    @Override
    public String start(){
        Scanner scan = new Scanner(System.in);
        String commend = scan.nextLine();
        return commend;
    };

    @Override
    public void end(){
        System.out.println("Game End");
    };

    public static Boolean selectType(Stage stage,String commend, Boolean state){
        switch (commend) {
            case END_COMMAND:
                state = false;
                break;
            case SINGLE_COMMAND:
                stage.singlePlay();
                break;
            case MULTI_COMMAND:
                stage.multiPlay();
                break;
            default:
                System.out.println("명령어 이외의 값을 입력하였습니다. 다시 한번 명령어를 확인해주세요.");
        }
        return state;
    }

}
