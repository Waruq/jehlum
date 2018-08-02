package com.jehlum;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3Client;

@SpringBootApplication
@EnableScheduling
public class JehlumApplication extends SpringBootServletInitializer  {
	
	@Value("${aws.awskey}")
	String awsKey;
	
	@Value("${aws.aws_key_id}")
	String awsId;
	
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(JehlumApplication.class);
	}
	
	public static void main(String[] args) {
		
		SpringApplication.run(JehlumApplication.class, args);
	}
	

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/jsp/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
    
    @SuppressWarnings("deprecation")
	@Bean
    public AmazonS3Client amazonS3Client() {
    	return new AmazonS3Client(awsCredentials());
    }
    
    @Bean
    public BasicAWSCredentials awsCredentials() {
    	BasicAWSCredentials credentials = new  BasicAWSCredentials(awsId,awsKey);
    	return credentials;
    }
}
