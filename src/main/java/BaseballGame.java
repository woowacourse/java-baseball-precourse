import java.util.*;
public class BaseballGame
{
    public static void main(String[] args)
    {
        //게임을 실행한다.
        doGame();
    }
    public static void doGame()
    {
        String strComputerNumber = generateComputerNumber(); //비교하기 편하게 computer number를 string으로 만든다.
        while(true)
        {
            String strUserNumber = getUserNumber(); //비교하기 편하게 user number를 string으로 만든다.
            int strikes = checkStrikes(strComputerNumber,strUserNumber); //스트라이크 수 return
            int balls = checkBalls(strComputerNumber, strUserNumber); //볼 수 return
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
        //지속의향 있을 시 재귀함수를 활용한다.
        boolean wantOneMoreGame = getUserAnswer();
        if(wantOneMoreGame)
        {
            doGame();//재귀함수
        }
    }

    public static String generateComputerNumber() //random한 숫자를 만든다.
    {
        int result = 0;
        ArrayList<Integer> list = new ArrayList<Integer>(); //random한 숫자를 만들기 위해 array_list를 만든다.
        for(int i=1; i<10; i++)
        {
            list.add(i);
        }
        int i = 0;
        int digit = 100; //자릿수
        while(i < 3)
        {
            int index = (int) (Math.random()*list.size());
            result += list.get(index)*digit;
            list.remove(index);
            i++;
            digit/=10;
        }
        String strResult = Integer.toString(result); //비교하기 쉽게 string으로 바꾼다.
        return strResult;
    }

    public static String getUserNumber() //user의 input을 받는다.
    {
        String strUserInput;
        while(true)
        {
            Scanner reader = new Scanner(System.in);
            System.out.print("숫자를 입력해주세요: ");
            strUserInput = reader.nextLine();
            boolean isUserInputRight = checkUserInput(strUserInput);//user의 input이 조건에 맞는지 확인한다.
            if(isUserInputRight)
            {
                break;
            }
        }
        return strUserInput;
    }

    public static boolean checkUserInput(String strUserInput) //user의 input이 맞는지 확인하는 method.
    {
        if(strUserInput.length() != 3) //user의 input이 세자리 수인지 확인.
        {
            System.out.println("서로 다른 세 숫자를 입력해 주세요!");
            return false;
        }
        if(isNonNumberThere(strUserInput)) //user의 input이 숫자로만 되어있는지 확인
        {
            System.out.println("숫자만 입력가능합니다!");
            return false;
        }
        //check zero
        if(isZeroThere(strUserInput)) //user의 input에 0이 포함되어 있는지 확인
        {
            System.out.println("숫자는 1~9까지만 입력해주세요!");
            return false;
        }
        //check repeating
        if(isRepeating(strUserInput)) //user의 input에 같은 숫자가 나오는지 확인.
        {
            System.out.println("숫자는 모두 다른 숫자를 입력하십시오!");
            return false;
        }
        return true;
    }

    public static boolean isNonNumberThere(String strUserInput) //숫자만 포함되어 있는지 확인.
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

    public static boolean isZeroThere(String strUserInput) //0이 있는지 확인.
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

    public static boolean isRepeating(String strUserInput) //중복하는 숫자가 있는지 확인.
    {
        for(int i=0, n = strUserInput.length(); i < n; i++)
        {
            String letter = String.valueOf(strUserInput.charAt(i));
            int count = strUserInput.length() - strUserInput.replace(letter, "").length();
            if(count > 1)
            {
                return true;
            }
        }
        return false;
    }

    public static int checkStrikes(String strComputerNumber, String strUserNumber) //스트라이트 수를 확인한다.
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

    public static int checkBalls(String strComputerNumber, String strUserNumber) //볼 수를 확인한다.
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

    public static boolean getUserAnswer() //user가 게임을 계속 할 의향이 있는지 묻는다.
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
                System.out.println("1이나 2를 입력해주세요!");
            }
        }
        return result;
    }
}