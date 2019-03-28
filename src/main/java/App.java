import java.util.*;
public class App {
    public static void main(String[] args) {

        //게임 종료 여부 저장
        boolean gameEnd = false;
        boolean correctAnswer = false;
        //게임 설명
        final String gameExplanation = "***숫자야구게임***\n" +
                "컴퓨터가 생각한 1~9사이의 서로 다른 세 숫자를 맞춰주세요\n" +
                "만약 정답이 아니라면 같은 수가 같은자리에 있으면 스트라이크\n" +
                "같은 수가 전혀 없으면 포볼 혹은 나씽이라는 힌트를 드립니다!";

        /*
         * 게임 종료 전까지 반복되는 기본 구조
         */
        do{
            int [] answerNumber = new int [3];  //정답인 세숫자
            int [] userNumber = new int [3];    //입력한 세숫자
            System.out.println(gameExplanation);//게임 설명 출력
            answerNumber=makeRandomNumber();    //난수(정답) 생성

            do {
                userNumber = saveUserInput();         //유저 입력 저장
                //두 수가 같은지 비교하여 정답일시 끝남
                correctAnswer = isCorrectAnswer(userNumber,answerNumber);
                printHint (userNumber,answerNumber);
            }while(correctAnswer == false);
            gameEnd = askRestart(); //재시작 여부를 물어보고 재시작 시 false를 종료 시 true를 반환




        } while(gameEnd == false);               //게임 종료 시 반복문 종료
    }


    /*
     * 난수(정답)생성 함수
     */
    private static int [] makeRandomNumber(){
        int [] numberArray = new int[3];         //세 숫자를 담을 배열을 생성
        int nowOrderNumber = 0;                   //0번~2번까지의 숫자를 총 세개 뽑아야함
        do{
            double randomNumber = Math.random();            //랜덤한 0이상 1미만의 실수를 저장
            int intNumber = (int) (randomNumber * 9) + 1;        //0이상 9미만의 실수를 정수로 형변환 해 0~8 사이의 정수로 만든후 1을 더해 1~9사이의 정수를 얻음

            //배열안에 같은 숫자가 있는지 검사 후 없으면 다음번 숫자로 넘어감
            if (inSameNumber(numberArray,intNumber) == false) {
                numberArray[nowOrderNumber] = intNumber;
                nowOrderNumber++;
            }
        } while(nowOrderNumber < 3);               //세번째 숫자가 찰 때 까지 반복

        return numberArray;
    }

    /*
     * 배열에 같은 숫자가 있는지 확인하는 함수
     */
    private static boolean inSameNumber(int[]numberArray, int target){
        boolean isIn = false;
        for (int i = 0; i<numberArray.length; i++){
            if (numberArray[i] == target){
                isIn = true;
            }
        }
        return isIn;
    }

    /*
     * 유저 입력 함수
     */
    private static int [] saveUserInput(){
        Scanner scan = new Scanner(System.in);
        boolean inputCorrect=false;
        int [] numberArray = new int[3];         //세 숫자를 담을 배열을 생성

        System.out.print("세 숫자를 입력해주세요: ");
        do {
            int userInput;
            //숫자 외의 입력이 있을시 예외처리
            try{
                userInput = scan.nextInt();
            }catch(InputMismatchException ime){ //정수가 아닌 문자열이 들어 왔을 때 처리할 문장
                System.out.println("숫자를 입력해주세요!");
                scan.next();
                continue;
            }

            numberArray= intToArray(userInput); //정수를 배열로 변환

            if (userInput < 99 || userInput > 999 ) {
                //세자리 숫자가 아닐 시 재입력
                System.out.println("세자리 숫자를 입력해 주세요");
            } else if(numberArray[0] == numberArray[1] || numberArray[1] == numberArray[2] || numberArray[2] == numberArray[0]){
                //같은 숫자가 있을 시 재입력
                System.out.println("중복되지 않은 숫자를 입력해 주세요");
            } else if (numberArray[1] == 0 || numberArray[2] == 0){
                //숫자에 0이 있을 시 재입력
                System.out.println("0이 아닌 숫자를 입력해 주세요");
            }else{
                inputCorrect = true; //탈출
            }
        } while(inputCorrect == false);
        return numberArray;
    }

    /*
     * 숫자 입력을 배열로 변환해주는 함수
     */
    private static int [] intToArray(int inputNumber){
        int [] numberArray = new int[3];         //세 숫자를 담을 배열을 생성
        numberArray[0] = inputNumber/100;
        numberArray[1] = (inputNumber%100)/10;
        numberArray[2] = inputNumber%10;
        return numberArray;
    }

    /*
     * 두 배열이 같은지 비교 해주는 함수
     */
    private static boolean isCorrectAnswer(int answerNumber[], int userNumber[]){
        boolean isCorrect = false;
        if (Arrays.equals(answerNumber, userNumber)) {
            isCorrect = true;
        }
        return isCorrect;
    }

    /*
     * 힌트 출력
     */
    private static void printHint(int computer[], int user[]){
        int strike =0;
        int ball=0;
        String printString = "";
        strike = countStrike(computer,user);
        ball = countBall(computer,user, strike);
        if (strike != 3) { // 3스트라이크면 정답
            if (strike > 0) {
                printString += strike + " 스트라이크 ";
            }
            if (ball > 0) {
                printString += ball + " 볼";
            }
            if (ball == 0 && strike ==0){
                String noSBString = noOrFour(); //나씽과 포볼 중 랜덤하게 저장
                printString = noSBString;
            }
            System.out.println(printString);
        }
    }

    /*
     * 스트라이크 카운팅
     */
    private static int countStrike(int computer[], int user[]){
        int count=0;
        for (int i = 0; i < 3; i++){
            if (computer[i] == user[i]){ //같은 위치 같은 숫자
                count++;
            }
        }
        return count;
    }

    /*
     * 볼 카운팅
     */
    private static int countBall(int computer[], int user[], int strike) {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            if (user[i] == computer[0] || user[i] == computer[1] || user[i] == computer[2]) { //같은 숫자 세기
                count++;
            }
        }
        count = count - strike; //스트라이크도 같은 숫자이므로 중복되지 않게 빼줌
        return count;
    }

    /*
     * 포볼 나씽 랜덤 함수
     */
    private static String noOrFour(){
        String output = "";
        double randomNumber = Math.random();            //랜덤한 0이상 1미만의 실수를 저장
        int intNumber = (int) (randomNumber * 2);       //0 혹은 1 출력
        if (intNumber == 0){
            output = "낫씽";
        } else{
            output = "포볼";
        }
        return output;
    }

    /*
     * 재시작 여부 입력
     */
    private static boolean askRestart(){

        Scanner scan = new Scanner(System.in);
        boolean inputCorrect=false;
        int userInput = 0;
        boolean end = false;
        System.out.println("정답입니다!");
        System.out.println("재시작을 원하시면 1, 종료를 원하시면 2를 입력해 주세요");

        //유저 종료 여부 입력
        do {
            //숫자 외의 입력이 있을시 예외처리
            try{
                userInput = scan.nextInt();
            }catch(InputMismatchException ime){ //정수가 아닌 문자열이 들어 왔을 때 처리할 문장
                System.out.println("숫자를 입력해주세요!");
                scan.next();
                continue;
            }

            //1,2 외의 숫자를 입력시 재입력 요구
            if (userInput != 1 && userInput !=2 ) {
                //세자리 숫자가 아닐 시 재입력
                System.out.println("1 혹은 2를 입력해 주세요.");
            }else{
                inputCorrect = true; //탈출
            }
        } while(inputCorrect == false);

        //1일시 종료하지 않음 2일시 종료
        if (userInput == 1){
            end = false;
        } else if (userInput == 2){
            end = true;
        }

        return end;
    }



}

