package tobyspring.config.autoconfig;

import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import tobyspring.config.MyAutoConfiguration;

@MyAutoConfiguration
public class ServerPropertiesConfig {

    @Bean
    public ServerProperties serverProperties(Environment env) {
//        ServerProperties properties = new ServerProperties();
//
//        properties.setContetxPath(env.getProperty("contextPath"));
//        properties.setPort(Integer.parseInt(env.getProperty("port")));
//
//        return properties;

        // 매번 getProperty("~~")로 가져올 수는 없다. 이 문제는 Binder에서 해결시켜줌
        return Binder.get(env).bind("", ServerProperties.class).get();
    }

}
