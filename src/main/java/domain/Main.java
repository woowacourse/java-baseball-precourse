/*
 * Main class
 * 
 * version?
 * 
 * 2019-11-30
 * 
 * patent?
 */

package domain;

public class Main {
	public static void main(String args[]) {
		User me = new User();
		while(!me.isValidNumber()) {
			me.enterNumber();
			System.out.println(me.getNumber());
		}
	}
}
