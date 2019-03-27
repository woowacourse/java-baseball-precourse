import java.util.Scanner;
public class App {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //게임 종료 여부 저장
        boolean gameEnd = false;
        int [] answerNumber=new int [3]; //정답인 세숫자
        //게임 설명
        final String gameExplanation="***숫자야구게임***\n" +
                "컴퓨터가 생각한 1~9사이의 서로 다른 세 숫자를 맞춰주세요\n" +
                "만약 정답이 아니라면 같은 수가 같은자리에 있으면 스트라이크\n" +
                "같은 수가 전혀 없으면 포볼 혹은 나씽이라는 힌트를 드립니다!";

        //게임 종료 전까지 반복되는 기본 구조
        do{
            System.out.println(gameExplanation);//게임 설명 출력
            answerNumber=makeRandomNumber();//난수(정답) 생성
        }while(gameEnd==true);//게임 종료 시 반복문 종료

    }

    //난수(정답)생성 함수
    private static int[] makeRandomNumber(){
        int [] numberArray= new int[3];//세 숫자를 담을 배열을 생성
        int nowOrderNumber=0; //0번~2번까지의 숫자를 총 세개 뽑아야함
        do{
            double randomNumber = Math.random(); //랜덤한 0이상 1미만의 실수를 저장
            int intNumber=(int)(randomNumber * 9)+1; //0이상 9미만의 실수를 정수로 형변환 해 0~8 사이의 정수로 만든후 1을 더해 1~9사이의 정수를 얻음
            //배열안에 같은 숫자가 있는지 검사 후 없으면 다음번 숫자로 넘어감
            if(inSameNumber(numberArray,intNumber)==false) {
                numberArray[nowOrderNumber] = intNumber;
                nowOrderNumber++;
            }
        }while(nowOrderNumber<3);//세번째 숫자가 찰 때 까지 반복

        return numberArray;
    }

    //배열에 같은 숫자가 있는지 확인하는 함수
    private static boolean inSameNumber(int[]numberArray,int target){
        boolean isIn=false;
        for(int i=0; i<numberArray.length; i++){
            if(numberArray[i]==target){
                isIn=true;
            }
        }
        return isIn;
    }
}

