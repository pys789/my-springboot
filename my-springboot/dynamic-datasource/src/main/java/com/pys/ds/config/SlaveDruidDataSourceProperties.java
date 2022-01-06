package com.pys.ds.config;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "spring.datasource.slave")
public class SlaveDruidDataSourceProperties {
    // jdbc
    private String driverClassName;
    private String url;
    private String username;
    private String password;
}