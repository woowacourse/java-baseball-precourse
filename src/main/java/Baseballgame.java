import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * Baseballgame
 */
public class Baseballgame {
    // 세 개로 이루어진 것을 알아보는 것이나, 다른 게임에 숫자가 늘어날 경우 대비
    private static int number_length =3;
    private Match match;
    private Scanner scan = new Scanner(System.in);
    private Number num;
    private int[] num_array;

    public void guessing(){
        String guess;
        char temp;
        while(true){
            try{
                System.out.print("숫자를 입력해주세요: ");
                guess = scan.next();
                //3자리 이상일 경우
                if (guess.length()!=number_length){
                    throw new InputMismatchException();
                }
                //숫자가 아닌 경우
                for (int i =0; i<guess.length(); i++){
                    temp = guess.charAt(i);
                    if (Character.isDigit(temp) == false){
                    throw new InputMismatchException();
                    }
                }
                break;
            }catch(InputMismatchException e){
                System.out.println(number_length+ "자리 숫자여야합니다. 다시 입력하시오.");
            }
        }
        //입력받은 수랑 computer의 수 비교
        match = new Match(num_array, guess);
        
    }

    //한 게임당 computer는 난수 생성 후 사용자가 맞춤(세번의 기회).
    public void game(){
        num = new Number(number_length);
        num_array = num.getDigits();
        //System.out.println(num.showDigits()+"num");
        for(int i =0; i<3; i++){
            guessing();
            if (match.getStrike()==3){
                System.out.println(number_length+"개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
            if (i==2){
                System.out.println(number_length+"개의 숫자를 모두 맞히지 못했습니다... 게임종료");
            }
        }
    }

    public static void main(String[] args) {
        Baseballgame baseballgame = new Baseballgame();
        baseballgame.game();
        int yesorno=0;
        while(true){
            try{
                System.out.println("게임을 새로 시작하려면1, 종료하려면 2를 입력하세요.");
                yesorno = baseballgame.scan.nextInt();
                if (!(yesorno==1 || yesorno==2)){
                    throw new InputMismatchException();
                }
                if (yesorno == 2){
                    break;
                }
                baseballgame.game();
            }catch(InputMismatchException e){
                System.out.println("1 아니면 2를 입력해야합니다. 다시 입력하시오.");
            }
           }
        
        
        }


}