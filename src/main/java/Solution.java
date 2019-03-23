
public class Solution {

    public static void main (String[] args) {
        boolean bool;
        Game game = new Game();
        String createdNumber;

        while(true) {
            createdNumber = game.generateNumber(3);
            bool = game.playGame(createdNumber);
            if (bool == false)
                break;
        }
    }

    void test() {
        boolean bool;
        CheckSomething check = new CheckSomething();
        String s = "hello";
        Game game = new Game();
        Oracle oracle = new Oracle();

        bool = check.checkLength(s, 5);
        System.out.println("is hello is 5 word?");
        System.out.println(bool);
        System.out.println();

        bool = check.checkNumber('3');
        System.out.println("is '3' is number?");
        System.out.println(bool);
        System.out.println();

        bool  = check.checkNumber('a');
        System.out.println("is 'a' is number?");
        System.out.println(bool);
        System.out.println();

        bool  = check.checkNumberString("12833");
        System.out.println("is 12833 is number?");
        System.out.println(bool);
        System.out.println();

        bool  = check.checkNumberString("300aa3");
        System.out.println("is 300a3 is number?");
        System.out.println(bool);
        System.out.println();

        bool  = check.checkRecievedNumber("33");
        System.out.println("is 33 is length 3 number?");
        System.out.println(bool);
        System.out.println();


        String generatedNumber = game.generateNumber(3);
        System.out.print("generatedNumber: ");
        System.out.println(generatedNumber);

        bool  = oracle.checkStrike("331","311",0);
        System.out.println("is 1st seat in 331 and 311 a strike?");
        System.out.println(bool);
        System.out.println();

        bool  = oracle.checkBall("448","545",1);
        System.out.println("is 2nd seat in 448 and 545 a ball?");
        System.out.println(bool);
        System.out.println();

        Result result  = oracle.tells("713","713");
        System.out.print("strike: ");
        System.out.println(result.strike);
        System.out.print("ball: ");
        System.out.println(result.ball);
        System.out.println();
    }
}
