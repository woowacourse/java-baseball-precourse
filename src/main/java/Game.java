import java.util.Scanner;

public class Game {
    private int strkes;
    private int balls;

    public Game(){
        this.strkes = 0;
        this.balls = 0;
    }

    public int isThereNumber(int[] arr, int target){
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == target)
                return i;
        }
        return -1;
    }

    public int judgingScore(int[] humanNumArray, int[] comNumArray){
        for(int i = 0; i< 3;i++) {
            //인덱스오브로 인덱스값 반환받아서 i랑 비교 인덱스가 -1이면 continue i랑 똑같다면 strike
            // 다르다면 ball
            int comIdx = isThereNumber(comNumArray, humanNumArray[i]);
            if (comIdx == -1) continue;
            else if (i == comIdx) strkes = strkes + 1;
            else if (i != comIdx) balls = balls + 1;
        }
        if(strkes == 3) return 1;
        else return 0;
    }

    public boolean continueGame(){
        System.out.println("1. 계속 2. 끝");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        if(choice == 1) return true;
        else return false;
    }

    public void initializeAgain(){
        this.strkes = 0;
        this.balls = 0;
    }

    public void showScore(){
        if(strkes == 0 && balls == 0)
            System.out.println("낫띵!!");
        else if(strkes == 0){
            System.out.println(balls + "볼");
        }
        else {
            System.out.println(strkes + "스트라이크" + balls + "볼");
        }
    }
}
