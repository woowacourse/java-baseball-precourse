import java.util.Random;

public class Computer {
    private int[] randomNumber;
    private boolean[] checkBoard;

    int[] getRandomNumber(){
        return randomNumber;
    }

    boolean[] getCheckBoard(){
        return checkBoard;
    }

    /*
     컴퓨터가 생성한 난수 배열내 원소의 중복 검사
     */

    boolean checkRandomNumber(int[] numbers){
        if ((numbers[0] != numbers[1])
                && (numbers[0] != numbers[2])
                && (numbers[1] != numbers[2]))
            return true;

        return false;
    }

    /*
     볼 판정을 위한 체크보드 배열 저장
     */

    void makeCheckBoard(int[] numbers){
        checkBoard = new boolean[10];

        for(int i=0; i<3; i++){
            checkBoard[numbers[i]] = true;
        }
    }

    /*
     1~9 사이의 난수 3자리를 임시저장
     임시저장된 배열의 중복 검사 후 최종저장
     */

    void generateRandomNumber(){
        Random random = new Random();
        int[] tempNumbers = new int[3];

        do{
            for(int i=0; i<3; i++){
                tempNumbers[i] = random.nextInt(9) + 1;
            }
        }while(!checkRandomNumber(tempNumbers));

        randomNumber = tempNumbers;
        makeCheckBoard(randomNumber);
    }

    /*
     사용자가 입력한 번호의 유효성 검사
     */

    boolean checkUserNumber(String number){
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

    /*
     스트라이크 및 볼 카운트
     난수와 사용자 입력이 같을 경우 종료를 위한 true 반환
     */

    boolean countStrikeAndBalls(boolean[] board, int[] comNumber, int[] userNumber){
        int strikeCount = 0;
        int ballCount = 0;

        for(int i=0; i<3; i++){
            if(comNumber[i] == userNumber[i]){
                strikeCount++;
            }else if(board[userNumber[i]]){
                ballCount++;
            }
        }

        if(strikeCount == 0 && ballCount == 0){
            System.out.print("낫싱");
        }
        if(strikeCount > 0){
            System.out.print(strikeCount);
            System.out.print(" 스트라이크 ");
        }
        if(ballCount > 0){
            System.out.print(ballCount);
            System.out.print(" 볼 ");
        }
        System.out.println();

        if(strikeCount == 3){
            System.out.println("3개의 숫자를 모두맞히셨습니다! 게임 종료.");
            return true;
        }

        return false;
    }
}