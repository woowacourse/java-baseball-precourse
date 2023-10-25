package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static camp.nextstep.edu.missionutils.Console.readLine;
import static java.lang.Integer.parseInt;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;


public class Application {



    public static String nothing() {

        return null;
    }










    public static List baseballResult() {
        List<Integer> resultNum = new ArrayList<>();
        List<Integer> pickNum = pickNum();
        List<Integer> getInput = getInput();

        for (int i = 0; i < pickNum.size(); i++) {
            if (pickNum.contains(getInput.get(i))) {
                resultNum.add(getInput.get(i));
                System.out.println(resultNum.size() + "스트라이크");

            }


        }

        return resultNum;
    }


/*else if (!pickNum().contains(getInput()) == true) {
        System.out.println("a_List 에는 " + getInput.get(i) + " 가 없다.");
    }*/


/*if (pickNum().contains(getInput()) == true) {*/

       /* for (int i=0; i<3; i++){
                resultnum.add(num.get(i));
                System.out.println(resultnum);*/



    public static List pickNum(){
        List<Integer> computer = new ArrayList<>();

        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);


            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
                System.out.print(randomNumber);
            }
        }

        return computer;

    }

/*    public static int getInput(){
        System.out.print("숫자를 입력하세요: ");
        int userInput = Integer.parseInt(readLine());
        return userInput;

    }*/






    public static List getInput(){
        System.out.print("숫자를 입력 하세요 : ");
        /*List<Integer> userInputList = new ArrayList<>();*/
        int userInput = Integer.parseInt(readLine());
        ArrayList<Integer> userInputList = new ArrayList<>();
        while(userInput > 0) {
            userInputList.add(userInput %10);
            userInput /= 10;
            Collections.reverse(userInputList);
        }
        /*System.out.println(userInputList);*/


        return userInputList;
    }


    /*int[] arrNum = Stream.of(String.valueOf(userInput)).mapToInt(Integer::parseInt).toArray();
        System.out.print(Arrays.toString(arrNum));
        userInputList.add(arrNum);*/

    /*int[] arrNum = new int[userInput.length()];
        for (int i = 0; i < userInput.length(); i++) {
        arrNum[i] = userInput.charAt(i) - '0';*/
    /*userInputList.add(userInput);*/
    /*int userInput = Integer.parseInt(readLine());*/





    /*int num = 12345;
    String strNum = Integer.toString(num);
    int[] arrNum = new int[strNum.length()];
for (int i = 0; i < strNum.length(); i++) {
        arrNum[i] = strNum.charAt(i) - '0';
    }
System.out.print(Arrays.toString(arrNum));
// [1, 2, 3, 4, 5]*/





    public static void main(String[] args) {
        //TODO: 숫자 야구 게임 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        pickNum();
        getInput();
        baseballResult();







    }
}
