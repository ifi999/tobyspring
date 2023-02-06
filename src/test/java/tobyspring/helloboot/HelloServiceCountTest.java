package tobyspring.helloboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

@HellobootTest
public class HelloServiceCountTest {

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    HelloRepository helloRepository;
    @Autowired
    HelloService helloService;

    @Test
    public void sayHelloIncreaseCount() {
        IntStream.rangeClosed(1, 10).forEach(count -> {
            helloService.sayHello("hi");
            assertThat(helloRepository.countOf("hi")).isEqualTo(count);
        });
    }

}
