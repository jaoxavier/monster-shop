package io.github.jaoxavier.monstershop;

import io.github.jaoxavier.monstershop.domain.entity.Monster;
import io.github.jaoxavier.monstershop.domain.repository.MonsterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import static io.github.jaoxavier.monstershop.domain.enums.Category.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MonsterShopApplication {

	@Autowired
	private MonsterRepository monsterRepository;
	@Bean
	public CommandLineRunner init(){
		return args -> {
				monsterRepository.save(new Monster("Monster Energy", 9.99, MONSTER_ENERGY));
				monsterRepository.save(new Monster("Low Carb", 9.99, MONSTER_ENERGY));
				monsterRepository.save(new Monster("Monter Energy 269", 9.99, MONSTER_ENERGY));
				monsterRepository.save(new Monster("Monter Energy 269", 5.99, MONSTER_ENERGY));

				monsterRepository.save(new Monster("Monster Ultra", 8.99, MONSTER_ULTRA));
				monsterRepository.save(new Monster("Ultra Paradise", 8.99, MONSTER_ULTRA));
				monsterRepository.save(new Monster("Ultra Violet", 6.99, MONSTER_ULTRA));

				monsterRepository.save(new Monster("Mango Loco", 10.50, JUICE_MONSTER));
				monsterRepository.save(new Monster("KHAOS", 9.99, JUICE_MONSTER));
				monsterRepository.save(new Monster("Pacific Punch", 9.99, JUICE_MONSTER));

				monsterRepository.save(new Monster("Dragon Ice Tea", 9.99, DRAGON_TEA));
				monsterRepository.save(new Monster("Dragon Ice Tea Peach", 9.99, DRAGON_TEA));
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(MonsterShopApplication.class, args);
	}

}
