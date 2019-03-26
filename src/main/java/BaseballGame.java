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

    public static String generateComputerNumber()
    {
        int result = 0;
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i=1; i<10; i++)
        {
            list.add(i);
        }
        int i = 0;
        int digit = 100;
        while(i < 3)
        {
            int index = (int) (Math.random()*list.size());
            result += list.get(index)*digit;
            list.remove(index);
            i++;
            digit/=10;
        }
        System.out.println(result);
        String strResult = Integer.toString(result);
        return strResult;
    }

    public static String getUserNumber()
    {
        String strUserInput;
        while(true)
        {
            Scanner reader = new Scanner(System.in);
            System.out.print("숫자를 입력해주세요: ");
            strUserInput = reader.nextLine();
            boolean isUserInputRight = checkUserInput(strUserInput);
            if(isUserInputRight)
            {
                break;
            }
        }
        return strUserInput;
    }



}