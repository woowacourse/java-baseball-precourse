package baseball;

public class Start {
    private static boolean CheckSelect(int select) throws IllegalArgumentException{
        if(select == 1 || select == 2)
            return true;
        throw new IllegalArgumentException("값을 확인하고 입력해주세요!");
    }
    public static boolean restart(int select) throws IllegalArgumentException{
        try{
            return CheckSelect(select);
        }catch (IllegalArgumentException i){
            System.out.println(i.getMessage());
        }
        return false;
    }
}
