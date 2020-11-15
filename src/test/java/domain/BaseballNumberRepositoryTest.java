package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;

class BaseballNumberRepositoryTest {

	@Test
	void testBaseballNumberRepository() {
		BaseballNumberRepository baseballNumberRepository = new BaseballNumberRepository();
		List<BaseballNumber> randomNumbers = baseballNumberRepository.randomNumbers();
		assertThat(randomNumbers.size()).isEqualTo(3);
	}
	
	@Test
	void testValidate() {
		BaseballNumberRepository baseballNumberRepository = new BaseballNumberRepository();
		Set<BaseballNumber> randomNumbers =new HashSet<>(baseballNumberRepository.randomNumbers());
		assertThat(randomNumbers.size()).isEqualTo(3);
	}
	
}
