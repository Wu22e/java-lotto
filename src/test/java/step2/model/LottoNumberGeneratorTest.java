package step2.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberGeneratorTest {

    @DisplayName("generate() 메소드는 로또 번호 6개를 리스트로 반환한다")
    @Test
    void generate_None_LottoNumbers() {
        List<LottoNumber> lottoNumbers = LottoNumberGenerator.generate();
        lottoNumbers.forEach(System.out::println);
        assertThat(lottoNumbers).hasSize(6);
    }
}
