import java.util.*;

public class BaseBall {

    /** 1부터 9까지 수를 가지는 numbers*/
    private List<Integer> numbers;

    public BaseBall() {
        numbers = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            numbers.add(i);
        }
    }

    /** numbers List를 셔플하여 앞에서 3개의 원소를 사용*/
    public void generateNumbers(){
        Collections.shuffle(numbers);
    }

    public void startProgram(){
        int endgame = 1;
        while(endgame == 1){
            this.startGame();
            Scanner scan = new Scanner(System.in);
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            endgame = scan.nextInt();
        }
        System.out.println("게임을 종료합니다.");
    }

    public void startGame(){
        int gameState = 0;
        this.generateNumbers();
        for (Integer i : numbers) {
            System.out.println(i);
        }
        while(gameState != 30){
            gameState = checkNumbers(inputThreeNumbers());
            showResult(gameState);
        }
    }

    public int inputThreeNumbers(){
        int threeNumbers;
        Scanner scan = new Scanner(System.in);
        System.out.println("숫자를 입력해주세요: ");
        threeNumbers = scan.nextInt();
        return threeNumbers;
    }
    /** 스트라이크는 10의 자리 볼은 1의 자리*/
    public int checkNumbers(int input){
        int result = 0;
        int a, b, c;
        a = input / 100;
        b = (input - a*100) /10;
        c = input%10;
        if (a == numbers.get(0)) {
            result += 10;
        }
        if (b == numbers.get(1)) {
            result += 10;
        }
        if (c == numbers.get(2)) {
            result += 10;
        }
        if (a == numbers.get(1) || a == numbers.get(2)) {
            result += 1;
        }
        if (b == numbers.get(0) || b == numbers.get(2)) {
            result += 1;
        }
        if (c == numbers.get(0) || c == numbers.get(1)) {
            result += 1;
        }
        return result;
    }

    public void showResult(int state){
        if (state == 0) {
            System.out.print("낫싱");
        }
        if (state >= 10){
            System.out.print(state/10 + "스트라이크 ");
        }
        if ((state%10) != 0){
            System.out.println(state%10 + "볼");
        }
        else{
            System.out.println();
        }
    }

    public static void main(String[] args) {
        BaseBall game = new BaseBall();
        game.startProgram();
    }
}

