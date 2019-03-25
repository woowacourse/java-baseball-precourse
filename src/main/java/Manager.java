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

        int strikeNum = 0;
        int ballNum = 0;
        System.out.println(comNums[0] + "," + comNums[1] + "," + comNums[2]);

        while(true){

            System.out.print("숫자를 입력해주세요 : ");
            int input = scanner.nextInt();
            userInput = parseArr(input);

            for (int i = 0; i < userInput.length; i++) {
                if(comNums[i] == userInput[i]){
                    strikeNum++;
                }
            }

            for (int j = 0; j < userInput.length; j++) {

                for (int k = 0; k < comNums.length; k++) {

                    if(comNums[j] == userInput[k] && j != k){
                        ballNum++;
                    }
                }
            }

            if(ballNum == 0) {
                System.out.println(strikeNum + "스트라이크");
            }else if (strikeNum == 0){
                System.out.println(ballNum + "볼");
            }else{
                System.out.println(strikeNum + "스트라이크" + ballNum + "볼");
            }


            if(strikeNum == 3){
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
                        "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                break;
            }
        }
    }

    private int[] parseArr(int input) {

        int first = input / 100;
        int second = (input % 100) / 10;
        int third = input % 10;

        return new int[]{first, second, third};
    }

}
