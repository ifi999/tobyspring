package tobyspring.helloboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@Transactional
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class HelloRepositoryTest {

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    HelloRepository helloRepository;

    @Test
    public void findHelloFailed() {
        assertThat(helloRepository.findHello("hello")).isNull();
    }

    @Test
    public void increaseCount() {
        assertThat(helloRepository.countOf("hello")).isEqualTo(0);

        helloRepository.increaseCount("hello");
        assertThat(helloRepository.countOf("hello")).isEqualTo(1);

        helloRepository.increaseCount("hello");
        assertThat(helloRepository.countOf("hello")).isEqualTo(2);
    }
}
