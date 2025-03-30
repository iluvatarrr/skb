package com.example.skb_spring.config;

import com.example.skb_spring.config.property.SomeProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import static com.example.skb_spring.common.Profile.TEST;

@Slf4j
@Configuration
@EnableConfigurationProperties(SomeProperty.class)
public class SomeConfig {

    @Bean
    @Profile(TEST)
    public String createTestProfileBean() {
        log.info("Create TestProfile bean");
        return "Test";
    }

    @Bean
    @ConditionalOnBean(name = "createTestProfileBean")
    public String createConditionalProfileBean() {
        log.info("Created ConditionalProfile bean");
        return "Cond";
    }

    @Bean
    @ConditionalOnExpression("#{'${app.env-val}' != 'default'}")
    public String createEnvValueProfileBean() {
        log.info("Creating EnvValue bean");
        return "Env";
    }
}
