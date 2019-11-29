package mypackage.minuyim.baseball.util;

public class ConvertToArray {
	
	public int[] convertToArray(int num) {
		String temp = Integer.toString(num);
		int[] nums = new int[temp.length()];
		
		for (int i = 0; i < temp.length(); i++) {
			nums[i] = temp.charAt(i) - '0';
		}
		return nums;
	}
}