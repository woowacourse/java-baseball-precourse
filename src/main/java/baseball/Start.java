package baseball;

public class Start {
    private static boolean CheckValue(int value) throws IllegalArgumentException{
        if(value == 1 || value == 2)
            return true;
        throw new IllegalArgumentException("값을 확인하고 입력해주세요!");
    }
    public static boolean Restart(int opinion) throws IllegalArgumentException{
        try{
            return CheckValue(opinion);
        }catch (IllegalArgumentException i){
            System.out.println(i.getMessage());
        }
        return false;
    }
}
