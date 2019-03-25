import java.util.HashMap;
import java.util.Scanner;

class Manager {

    private Computer computer;
    private Scanner scanner;

    Manager(){
        this.computer = new Computer();
        scanner = new Scanner(System.in);
    }

    private void initScore() {
        computer = new Computer();
        computer.getComputerNumMap().clear();
        computer.saveComputerNums();
    }

    void startGame(){
        int[] comNums = computer.getComputerNum();
        int[] userInput;
        System.out.println(comNums[0] + "," + comNums[1] + "," + comNums[2]);

        do {
            String validInput = userNumInput();
            userInput = parseArr(Integer.parseInt(validInput));
        } while (!getScore(userInput));
    }

    private boolean getScore(int[] userinput) {
        HashMap<Integer, ComputerNum> data = computer.getComputerNumMap();
        int ball = 0;
        int strike = 0;
        int nothing = 0;

        for (int i = 0; i < userinput.length; i++) {
            if (!data.containsKey(userinput[i])){
                nothing++;
            }else if (data.get(userinput[i]).getIndex() == i && data.get(userinput[i]).getNumInfo() == userinput[i]){
                strike++;
            }else{
                ball++;
            }
        }

        if (nothing == 3){
            System.out.print("낫싱");
        }

        if(strike == 3){
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            endGame();
            return true;
        }else if (strike > 0){
            System.out.print(strike + " 스트라이크 ");
        }

        if (ball > 0){
            System.out.print(ball + " 볼");
        }

        System.out.println();

        return false;
    }

    private String userNumInput(){
        boolean checkInput = true;
        String input = "";
        while(checkInput){
            System.out.print("숫자를 입력해주세요 : ");
            input = scanner.next();
            checkInput = checkUserInput(input);
        }
        return input;
    }

    private boolean checkUserInput(String input){
        try{
            Integer.parseInt(input);
        }catch (NumberFormatException e){
            System.out.println(ErrorCodes.INPUT_FORMAT_ERROR);
            return true;
        }

        if (input.length() != 3){
            System.out.println(ErrorCodes.INPUT_LENGTH_ERROR);
            return true;
        }

        if(input.charAt(0) == input.charAt(1) || input.charAt(0) == input.charAt(2) || input.charAt(1) == input.charAt(2)){
            System.out.println(ErrorCodes.INPUT_DUPLICATE_ERROR);
            return true;
        }

        return false;
    }

    private boolean checkEndCommand(String endOption){

        try{
            Integer.parseInt(endOption);
        }catch (NumberFormatException e){
            System.out.println(ErrorCodes.INPUT_FORMAT_ERROR);
            return true;
        }

        if (endOption.length() == 1){
            if (endOption.equals("2")) {
                System.exit(0);
                return false;
            }else if(endOption.equals("1")){
                initScore();
                startGame();
                return false;
            }else{
                System.out.println(ErrorCodes.INPUT_OTHER_NUM_ERROR);
                return true;
            }

        }else{
            System.out.println(ErrorCodes.INPUT_OTHER_NUM_ERROR);
            return true;
        }
    }

    private void endGame() {
        boolean endOptionValid = true;

        while(endOptionValid){
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String endCommand = scanner.next();
            endOptionValid = checkEndCommand(endCommand);
        }
    }

    private int[] parseArr(int input) {
        int first = input / 100;
        int second = (input % 100) / 10;
        int third = input % 10;
        return new int[]{first, second, third};
    }

}
