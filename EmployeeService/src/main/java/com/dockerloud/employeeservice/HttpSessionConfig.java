package com.dockerloud.employeeservice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.http.HeaderHttpSessionStrategy;
import org.springframework.session.web.http.HttpSessionStrategy;

@Configuration
@EnableRedisHttpSession 
public class HttpSessionConfig {

        @Bean
        public LettuceConnectionFactory connectionFactory() {
           	LettuceConnectionFactory factory =  new LettuceConnectionFactory(); 
        	factory.setDatabase(0);
        	factory.setHostName("192.168.1.14");
        	factory.setPassword("redispassword");
        	factory.setPort(6379);
        	return factory;
        }

        @Bean
        public HttpSessionStrategy httpSessionStrategy() {
                return new HeaderHttpSessionStrategy(); 
        }
}