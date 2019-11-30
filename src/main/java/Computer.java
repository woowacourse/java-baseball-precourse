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

    boolean check_userNumber(String number){
        try{
            Integer.parseInt(number);
        }catch(NumberFormatException e){
            System.out.println("숫자가 아닙니다. 숫자를 입력하세요.");
            return false;
        }

        if(number.length() != 3) {
            System.out.println("길이가 유효하지 않습니다. 3자리 숫자를 입력하세요.");
            return false;
        }else if(number.indexOf("0") > 0){
            System.out.println("0이 포함되어 있습니다. 1~9 사이의 숫자를 입력하세요.");
            return false;
        }else if((number.charAt(0) == number.charAt(1))
                || (number.charAt(0) == number.charAt(2))
                || (number.charAt(1) == number.charAt(2))){
            System.out.println("중복된 숫자가 있습니다. 중복없이 입력해주세요");
            return false;
        }

        return true;
    }
}