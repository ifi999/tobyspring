package tobyspring.helloboot;

import org.springframework.boot.SpringApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import tobyspring.config.MySpringBootApplication;

import javax.annotation.PostConstruct;

@MySpringBootApplication
public class HellobootApplication {

//	@Bean
//	ApplicationRunner applicationRunner(Environment env) {
//		return args -> {
//			// application.properties 에 작성했지만,
//			// application properties 설정(위 상단 메뉴바 런할 때 거기)에서 environment variables 값과 system variables 값을 설정하였는데
//			// 가장 우선순위가 높은 system property 값이 불러와진다
//			String name = env.getProperty("my.name");
//			System.out.println("my.name : " + name);
//		};
//	}

	private final JdbcTemplate jdbcTemplate;

	public HellobootApplication(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@PostConstruct
	void init() {
		jdbcTemplate.execute("create table if not exists hello(name varchar(50) primary key, count int)");
	}

	public static void main(String[] args) {
		SpringApplication.run(HellobootApplication.class, args);
	}

}
