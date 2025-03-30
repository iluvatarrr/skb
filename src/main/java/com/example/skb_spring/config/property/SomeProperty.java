package com.example.skb_spring.config.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import java.util.List;

@Data
@ConfigurationProperties(prefix = "app")
public class SomeProperty {
    String name;
    List<String> list;
}
