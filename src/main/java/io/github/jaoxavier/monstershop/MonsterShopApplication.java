package io.github.jaoxavier.monstershop;

import io.github.jaoxavier.monstershop.domain.entity.Monster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MonsterShopApplication {
	@Bean
	public CommandLineRunner init(@Autowired Monster monster){
		return args -> {
				Monster monster1 = new Monster();
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(MonsterShopApplication.class, args);
	}

}
