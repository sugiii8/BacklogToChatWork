package com.example.backlogtocw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.example.backlogtocw.config.ApplicationProperties;

/**
 * spring bootの起動(アプリケーション起動の起点)
 */
@SpringBootApplication
@EnableConfigurationProperties(ApplicationProperties.class)
public class BacklogToChatworkApplication {

	public static void main(String[] args) {
		SpringApplication.run(BacklogToChatworkApplication.class, args);
	}
}
