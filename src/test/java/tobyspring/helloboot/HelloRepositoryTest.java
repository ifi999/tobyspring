package tobyspring.helloboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.assertj.core.api.Assertions.assertThat;

@HellobootTest
public class HelloRepositoryTest {

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    HelloRepository helloRepository;

    @BeforeEach
    void init() {
        jdbcTemplate.execute("create table if not exists hello(name varchar(50) primary key, count int)");
    }

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
