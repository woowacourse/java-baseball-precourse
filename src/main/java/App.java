import java.util.Scanner;
public class App {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean gameEnd = false;//게임 종료 여부 저장
        final String gameExplanation="***숫자야구게임***\n" +
                "컴퓨터가 생각한 1~9사이의 서로 다른 세 숫자를 맞춰주세요\n" +
                "만약 정답이 아니라면 같은 수가 같은자리에 있으면 스트라이크\n" +
                "같은 수가 전혀 없으면 포볼 혹은 나씽이라는 힌트를 드립니다!";
        //게임 종료 전까지 반복되는 기본 구조
        do{
            System.out.println(gameExplanation);//게임 설명 출력

        }while(gameEnd==true);//게임 종료 시 반복문 종료
    }
}