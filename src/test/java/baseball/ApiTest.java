package baseball;

import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.Randoms;

public class ApiTest {
	@Test
	public void randoms() throws Exception {
	    //given
		//when
		for (int i = 0; i < 10; i++){
			System.out.println(Randoms.pickNumberInRange(1, 9));
		}
	    //then
	}

}
