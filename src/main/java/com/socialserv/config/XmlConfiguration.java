package com.socialserv.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath*:spring/springBeanConfig.xml")
public class XmlConfiguration {
}
