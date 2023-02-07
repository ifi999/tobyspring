package tobyspring.helloboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.assertj.core.api.Assertions.assertThat;

@JdbcTest
//@Rollback(value = false)
public class JdbcTemplateTest {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    public void insertAndQuery() {
        jdbcTemplate.update("insert into hello values(?, ?)", "hi", 10);
        jdbcTemplate.update("insert into hello values(?, ?)", "spring", 13);

        Long count = jdbcTemplate.queryForObject("select count(*) from hello", Long.class);
        assertThat(count).isEqualTo(2);
    }

    @Test
    public void insertAndQuery2() {
        jdbcTemplate.update("insert into hello values(?, ?)", "hi2", 10);
        jdbcTemplate.update("insert into hello values(?, ?)", "spring2", 13);

        Long count = jdbcTemplate.queryForObject("select count(*) from hello", Long.class);
        assertThat(count).isEqualTo(2);
    }
}
