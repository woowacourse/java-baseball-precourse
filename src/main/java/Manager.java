import java.util.Scanner;

public class Manager {

    private Computer computer;
    private Scanner scanner;

    Manager(){
        this.computer = new Computer();
        scanner = new Scanner(System.in);
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
                System.exit(0);
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

    private int[] parseArr(int input) {

        int first = input / 100;
        int second = (input % 100) / 10;
        int third = input % 10;

        return new int[]{first, second, third};
    }

}
