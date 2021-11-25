package baseball;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        //TODO: 숫자 야구 게임 구현
        ArrayList<Integer> computerNumbers = new ArrayList<Integer>();
        ArrayList<Integer> userNumbers = new ArrayList<Integer>();

        computerNumbers = ComputerNumbers.ComputerNumbers();
        userNumbers = UserNumbers.UserNumbers();

        //Random test
        //for (int i = 0; i < computerNumbers.size(); i++)
        //  System.out.print(computerNumbers.get(i));

    }
}
