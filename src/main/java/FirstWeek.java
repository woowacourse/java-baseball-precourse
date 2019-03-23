
public class FirstWeek {

    public static void main (String[] args) {
        boolean bool;
        String s = "hello";
        CheckSomething check = new CheckSomething();

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

        bool  = check.checkNumbers("12833");
        System.out.println("is 12833 is number?");
        System.out.println(bool);
        System.out.println();

        bool  = check.checkNumbers("300aa3");
        System.out.println("is 300a3 is number?");
        System.out.println(bool);
        System.out.println();


    }
}
