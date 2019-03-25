import java.util.Scanner;

public class Manager {

    private Computer computer;
    private Scanner scanner;

    Manager(){
        this.computer = new Computer();
        scanner = new Scanner(System.in);
    }

    private void initScore() {
        computer = new Computer();
    }

    void startGame(){
        int[] comNums = computer.getComputerNum();
        int[] userInput;
        System.out.println(comNums[0] + "," + comNums[1] + "," + comNums[2]);

        while (true) {
            String validInput = userNumInput();
            userInput = parseArr(Integer.parseInt(validInput));

            int strikeNum = getStrikeCount(comNums, userInput);
            int ballNum = getBallCount(comNums, userInput);

            if (strikeNum == 0 && ballNum == 0){
                System.out.println("낫싱");
            }else{
                printResult(strikeNum,ballNum);
            }

            if (strikeNum == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                endGame();
                break;
            }
        }
    }

    private String userNumInput(){
        boolean checkInput = true;
        String input = "";
        while(checkInput){
            System.out.println("숫자를 입력해주세요 : ");
            input = scanner.next();
            checkInput = checkUserInput(input);
        }
        return input;
    }

    private boolean checkUserInput(String input){
        try{
            Integer.parseInt(input);
        }catch (NumberFormatException e){
            System.out.println("입력은 숫자만 가능합니다.!");
            return true;
        }

        if (input.length() != 3){
            System.out.println("숫자는 3 자리만 입력해주세요.!");
            return true;
        }

        if(input.charAt(0) == input.charAt(1) || input.charAt(0) == input.charAt(2) || input.charAt(1) == input.charAt(2)){
            System.out.println("중복되지않는 서로다른 세자리숫자를 입력하세요!!");
            return true;
        }

        return false;
    }

    private int getStrikeCount(int[] comNums, int[] userInput) {
        int strikeNum = 0;
        for (int i = 0; i < userInput.length; i++) {
            if (comNums[i] == userInput[i]) {
                strikeNum++;
            }
        }
        return strikeNum;
    }

    private int getBallCount(int[] comNums, int[] userInput) {
        int ball = 0;
        for (int i = 0; i < userInput.length; i++) {
            for (int j = 0; j < comNums.length; j++) {
                if (comNums[i] == userInput[j] && i != j) {
                    ball++;
                }
            }
        }
        return ball;
    }

    private void printResult(int strikeNum, int ballNum){
        if(strikeNum == 0){
            System.out.println(ballNum + " 볼");
        }else if(ballNum == 0){
            System.out.println(strikeNum + " 스트라이크");
        }else{
            System.out.println(strikeNum + " 스트라이크 " + ballNum + " 볼");
        }
    }

    private boolean checkEndCommand(String endOption){

        try{
            Integer.parseInt(endOption);
        }catch (NumberFormatException e){
            System.out.println("숫자만 입력해주세요.");
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
                System.out.println("숫자는 1 또는 2만 입력해주세요");
                return true;
            }

        }else{
            System.out.println("숫자는 1과 2중에 하나만 입력해주세요");
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
