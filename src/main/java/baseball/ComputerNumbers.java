package baseball;

import java.util.ArrayList;
import baseball.RandomGenerator;

public class ComputerNumbers {
    public static ArrayList<Integer> ComputerNumbers;

    public static ArrayList<Integer> ComputerNumbers(){
        ArrayList<Integer> computerNumbers = new ArrayList<Integer>();
        computerNumbers = RandomGenerator.RandomGenerator();
        return computerNumbers;
    }
}
