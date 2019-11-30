import java.util.Random;

public class Computer {
    private int[] randomNumber;
    private boolean[] checkBoard;

    Computer(){
        generate_randomNumber();
    }

    int[] get_randomNumber(){
        return randomNumber;
    }

    boolean[] get_checkBoard(){
        return checkBoard;
    }

    boolean check_randomNumber(int[] numbers){
        if ((numbers[0] != numbers[1]) && (numbers[0] != numbers[2]) && (numbers[1] != numbers[2]))
            return true;

        return false;
    }

    void make_checkBoard(int[] numbers){
        checkBoard = new boolean[10];

        for(int i=0; i<3; i++){
            checkBoard[numbers[i]] = true;
        }
    }

    void generate_randomNumber(){
        Random random = new Random();
        int[] tempNumbers = new int[3];

        do{
            for(int i=0; i<3; i++){
                tempNumbers[i] = random.nextInt(9) + 1;
            }
        }while(!check_randomNumber(tempNumbers));

        randomNumber = tempNumbers;
        make_checkBoard(randomNumber);
    }

}