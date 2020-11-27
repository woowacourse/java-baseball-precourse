package number;

import view.OutputView;
import java.util.Scanner;

/**
 * @author junyoung.choi
 */
public class PlayerNumber {

    private String inputNumber;
    private int[] playerNum = new int[3];
    private Scanner scanner = new Scanner(System.in);

    public PlayerNumber(){
        OutputView.showInputNumber();
        this.inputNumber = writeInputNumber();
    }

    public String writeInputNumber(){
        return scanner.next();
    }

    public String getInputNumber(){
        return inputNumber;
    }

    public void makeArray(){
        String[] temp = inputNumber.split("");
        for(int i=0;i<3;i++){
            playerNum[i] = Integer.parseInt(temp[i]);
        }

    }

    public int[] getPlayerNumber(){
        return playerNum;
    }



}