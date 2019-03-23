
public class FirstWeek {

    public static void main (String[] args) {
        boolean bool;
        String s = "hello world!";
        CheckSomething check = new CheckSomething();
        bool = check.checkLength(s, 10);
        //bool = check.checkNumber('3');

        System.out.println(bool);
        System.out.println("hello world!");

    }
}
