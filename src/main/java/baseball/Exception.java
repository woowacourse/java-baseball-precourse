package baseball;

import java.util.HashMap;

public class Exception {
    private static final int LENGTHNUMBER=3;
    public boolean inZero(String stringInput){
        boolean branchPoint=false;
        for(int i=0;i<LENGTHNUMBER;i++) {
            if(stringInput.charAt(i)=='0'){
                branchPoint=true;
                throw new IllegalArgumentException("0은 들어가면 안됩니다.");
            }
        }
        if(branchPoint){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean correctLen(String stringInput){
        boolean branchPoint=false;
        if(stringInput.length()!=3){
            branchPoint=true;
            throw new IllegalArgumentException("숫자의 길이는 3이여야 합니다.");
        }
        if(branchPoint){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean inExceptNumber(String stringInput){
        try{
            Integer.parseInt(stringInput);
            return false;
        }catch(NumberFormatException e){
            throw new IllegalArgumentException("올바른 숫자를 입력하셔야합니다.");
        }
    }
    public boolean inNegative(String stringInput){
        boolean branchPoint=false;
        if(Integer.parseInt(stringInput)<0){
            branchPoint=true;
            throw new IllegalArgumentException("양수를 입력하셔야 합니다.");
        }
        if(branchPoint){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean inDuplicateNumber(String stringInput){
        boolean branchPoint=false;
        HashMap<Character,Integer> hashMap=hashDuplicateNumber(stringInput);

        for(int i=0;i<LENGTHNUMBER;i++){
            if(hashMap.get(stringInput.charAt(0))>1){
                branchPoint=true;
                throw new IllegalArgumentException("서로 다른 임의의 숫자 3개를 입력하셔야 합니다.");
            }
        }
        if(branchPoint){
            return true;
        }
        else{
            return false;
        }

    }
    public HashMap<Character,Integer> hashDuplicateNumber(String stringInput){
        HashMap<Character,Integer> hashMap = new HashMap<Character, Integer>();
        for(int i=0;i<LENGTHNUMBER;i++){
            if(hashMap.containsKey(stringInput.charAt(i))){
                int tmpInt=hashMap.get(stringInput.charAt(i));
                hashMap.put(stringInput.charAt(i),tmpInt+1);
            }
            else{
                hashMap.put(stringInput.charAt(i),1);
            }
        }
        return hashMap;
    }
    public boolean navigateChoiceNumber(String choiceNumber){
        boolean branchPoint=false;
        int intChoiceNumber=Integer.parseInt(choiceNumber);
        if(intChoiceNumber!=1 && intChoiceNumber!=2){
            branchPoint=true;
            throw new IllegalArgumentException("1또는 2를 입력해주세요");
        }
        if(branchPoint){
            return false;
        }
        else{
            return true;
        }
    }
}
