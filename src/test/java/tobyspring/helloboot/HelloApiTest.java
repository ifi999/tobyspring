package tobyspring.helloboot;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloApiTest {
    @Test
    public void helloApi() {
        // http localhost:8080/app/hello?name=ifi999
        TestRestTemplate rest = new TestRestTemplate();

        String url = "http://localhost:9090/app/hello?name={name}";
        ResponseEntity<String> res
                = rest.getForEntity(url, String.class, "ifi999");

        // status code 200
        assertThat(res.getStatusCode()).isEqualTo(HttpStatus.OK);
        // header(content-type) text/plain
        assertThat(res.getHeaders().getFirst(HttpHeaders.CONTENT_TYPE)).startsWith(MediaType.TEXT_PLAIN_VALUE);
        // body Hello ifi999
        assertThat(res.getBody()).isEqualTo("*** Hello ifi999 ***");
    }

    @Test
    public void failHelloApi() {
        // http localhost:8080/app/hello?name=ifi999
        TestRestTemplate rest = new TestRestTemplate();

        String url = "http://localhost:9090/app/hello?name=";
        ResponseEntity<String> res
                = rest.getForEntity(url, String.class);

        assertThat(res.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
