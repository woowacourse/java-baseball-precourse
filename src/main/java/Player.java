import java.util.Scanner;

public abstract class Player {

    protected char[] nums;

    public Player(int num_len){
        nums = new char[num_len];
    }

    public boolean check_duplication(char[] tmp_nums) {
        for(char c:tmp_nums){
            if (!(new String(tmp_nums).contains(String.valueOf(c)))) {
                return true;
            }
        }
        return false;
    }

    public boolean getNumber() {
        System.out.println("숫자를 입력해주세요: ");
        Scanner scan = new Scanner(System.in);
        String tmp_nums = scan.nextLine().trim();
        if (tmp_nums.length() == nums.length) {
            try {
                int foo = Integer.parseInt(tmp_nums);
                nums = tmp_nums.toCharArray();
            } catch (Exception e) {
                System.out.println("잘못된 입력입니다1.");
                return true;
            }
        } else{
            System.out.println("잘못된 입력입니다2.");
            return true;
        }
        if(check_duplication(nums)){
            System.out.println("잘못된 입력입니다3.");
            return true;
        }
        return false;
    }
}
