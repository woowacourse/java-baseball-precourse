/*
 * 입력 받은 데이터가 유효한지 검증을 수행하는 클래스
 *
 * @version 1.0
 *
 * @date 2019.12.02
 * 
 * @author Jung dahee
 */

public class InputVerification {
	
    Printer printer = new Printer();
	
    /*
     * 들어온 데이터가 유효한 값인지 확인 후 반환하는 메소드
     */
    public boolean checkData(String player) {
        return checkNum(player) && checkNumCnt(player)
		&& checkZeroNum(player) && checkDupNum(player);
    }
	
    /*
     * 숫자로만 이루어진 입력 값인지 확인하는 메소드
     */
    private boolean checkNum(String player) { 
    	try {
    	    Integer.parseInt(player);
    	    return true;
    	} catch(NumberFormatException e) {
    	    return false;
    	}
    }
    
    /*
     * 들어온 데이터에 중복된 수가 없는지 확인하는 메소드
     */
    private boolean checkDupNum(String player) { 
    	return (player.charAt(0) != player.charAt(1)) 
    		&& (player.charAt(1) != player.charAt(2))
    		&& (player.charAt(0) != player.charAt(2));
    }
}
