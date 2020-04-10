package com.muskan.bookmyshowmuskan;

import com.muskan.bookmyshowmuskan.bo.UserSession;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

@SpringBootApplication
public class BookmyshowmuskanApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookmyshowmuskanApplication.class, args);

	}

	@Bean
	@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
	public UserSession getUserSession(){
		return new UserSession();
	}

}
