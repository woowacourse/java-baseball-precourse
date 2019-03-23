
public class FirstWeek {

    public static void main (String[] args) {
        boolean bool;
        String s = "hello";
        CheckSomething check = new CheckSomething();
        Game g = new Game();

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

        g.recieveNumber();

    }
}
