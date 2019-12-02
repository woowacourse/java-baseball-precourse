public class GenerateNumber {
    public String make(){
        double randomValue = Math.random();
        int tempNum = (int) (randomValue * 987) + 123;

        System.out.println(tempNum);

        return Integer.toString(tempNum);
    }
}
