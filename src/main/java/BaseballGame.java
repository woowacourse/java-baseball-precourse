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

    public static boolean checkUserInput(String strUserInput)
    {
        if(strUserInput.length() != 3)
        {
            System.out.println("서로 다른 세 숫자를 입력해 주세요!");
            return false;
        }
        if(isNonNumberThere(strUserInput))
        {
            System.out.println("숫자만 입력가능합니다!");
            return false;
        }
        //check zero
        if(isZeroThere(strUserInput))
        {
            System.out.println("숫자는 1~9까지만 입력해주세요!");
            return false;
        }
        //check repeating
        if(isRepeating(strUserInput))
        {
            System.out.println("숫자는 모두 다른 숫자를 입력하십시오!");
            return false;
        }
        return true;
    }

    public static boolean isNonNumberThere(String strUserInput)
    {
        for(int i = 0, n = strUserInput.length(); i<n; i++)
        {
            if(Character.isDigit(strUserInput.charAt(i)))
            {
                continue;
            }
            else
            {
                return true;
            }
        }
        return false;
    }

    public static boolean isZeroThere(String strUserInput)
    {
        for(int i=0, n=strUserInput.length(); i<n; i++)
        {
            if(strUserInput.charAt(i) == '0')
            {
                return true;
            }
        }
        return false;
    }

    public static boolean isRepeating(String strUserInput)
    {
        for(int i=0, n = strUserInput.length(); i < n; i++)
        {
            String letter = String.valueOf(strUserInput.charAt(i));
            int count = strUserInput.length() - strUserInput.replace(letter, "").length();
            if(count > 1);
            {
                return true;
            }
        }
        return false;
    }

    public static int checkStrikes(String strComputerNumber, String strUserNumber)
    {
        int count = 0;
        String combined = strComputerNumber + strUserNumber;
        for(int i = 0, n = combined.length(); i<n-3; i++)
        {
            if(combined.charAt(i) == combined.charAt(i+3))
            {
                count++;
            }
        }
        return count;
    }

    public static int checkBalls(String strComputerNumber, String strUserNumber)
    {
        int count = 0;
        for (int i =0, n = strComputerNumber.length();i<n;i++)
        {
            int index = strUserNumber.indexOf(strComputerNumber.charAt(i));
            if(index != -1 && index != i)
            {
                count++;
            }
        }
        return count;
    }

    public static boolean getUserAnswer()
    {
        boolean result;
        while(true)
        {
            Scanner scanner = new Scanner(System.in);
            System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요: ");
            String strUserInput = scanner.nextLine();
            if(strUserInput.length() == 1 && strUserInput.charAt(0) == '1')
            {
                result = true;
                break;
            }
            else if(strUserInput.length() == 1 && strUserInput.charAt(0) == '2')
            {
                result = false;
                break;
            }
            else
            {
                System.out.println("1이나 2를 입렬해주세요!");
            }
        }
        return result;
    }
}