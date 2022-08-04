package kr.flab.baseballapi.infrastructure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "kr.flab.baseballapi" })
public class BaseballApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BaseballApiApplication.class, args);
	}

}
