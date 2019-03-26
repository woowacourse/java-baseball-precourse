import java.util.*;
public class BaseballGame
{
    public static void main(String[] args)
    {
        doGame();
    }
    public static void doGame()
    {

        String strComputerNumber = generateComputerNumber();
        while(true)
        {
            String strUserNumber = getUserNumber();
            int strikes = checkStrikes(strComputerNumber,strUserNumber);
            int balls = checkBalls(strComputerNumber, strUserNumber);
            if(strikes == 3 && balls == 0)
            {
                System.out.println("3 스트라이크");
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
                break;
            }
            else if(strikes == 0 && balls == 0)
            {
                System.out.println("낫싱!");
            }
            else if(balls == 0)
            {
                System.out.println(strikes + " 스트라이크");
            }
            else if(strikes == 0)
            {
                System.out.println(balls + " 볼");
            }
            else
            {
                System.out.println(strikes + " 스트라이크 " + balls + " 볼");
            }
        }
        //do one more time? ask user input!
        boolean wantOneMoreGame = getUserAnswer();
        if(wantOneMoreGame)
        {
            doGame();
        }
    }

}