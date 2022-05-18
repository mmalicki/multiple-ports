package com.example.multipleports;

import org.apache.catalina.connector.Connector;

import org.apache.coyote.http11.Http11NioProtocol;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class TomcatConfiguration {
    @Bean
    public ServletWebServerFactory customerContainer() {
        var serverFactory = new TomcatServletWebServerFactory();
        List.of(8081, 8082).forEach(port -> {
            var connector = new Connector(new Http11NioProtocol());
            connector.setPort(port);
            serverFactory.addAdditionalTomcatConnectors(connector);
        });
        return serverFactory;
    }
}
