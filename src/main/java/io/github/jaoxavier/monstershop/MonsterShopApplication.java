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
				monsterRepository.save(new Monster("Monster Energy",  9.99, MONSTER_ENERGY, 50, "https://marvel-b1-cdn.bc0a.com/f00000000104050/www.monsterenergy.com/media/uploads_image/2016/06/22/auto/800/7dd2cc96f5c8ee7c1658e8f88d362a5a.png?mod=v1_c863764535e9284ff34f366929dbf8ab"));
				monsterRepository.save(new Monster("Low Carb", 9.99, MONSTER_ENERGY, 40, "https://marvel-b1-cdn.bc0a.com/f00000000104050/www.monsterenergy.com/media/uploads_image/2016/06/22/auto/800/b2203e305c5590b9a34fc1b954b0d5d1.png?mod=v1_c863764535e9284ff34f366929dbf8ab"));
				monsterRepository.save(new Monster("Absolutely Zero", 9.99, MONSTER_ENERGY, 48, "https://marvel-b1-cdn.bc0a.com/f00000000104050/www.monsterenergy.com/media/uploads_image/2019/07/24/auto/800/ab21f0a5199bb0ded0a5001397e67dc9.png?mod=v1_c1b5c24fc00dfdfb1249cdfd5a1f1135"));
				monsterRepository.save(new Monster("Monster Energy 269", 5.99, MONSTER_ENERGY, 35, "https://marvel-b1-cdn.bc0a.com/f00000000104050/www.monsterenergy.com/media/uploads_image/2020/10/27/auto/800/f4259e5057edd221b705d8e7d7798ee9.png?mod=v1_54d80f859533b216e4decffb21cf22c5"));

				monsterRepository.save(new Monster("Monster Ultra", 8.99, MONSTER_ULTRA, 45, "https://marvel-b1-cdn.bc0a.com/f00000000104050/www.monsterenergy.com/media/uploads_image/2017/08/15/auto/800/4f329c38df8f392e2df5758e8c90da00.png?mod=v1_9aefa8bc60cc4f15db6ebc86211b843a"));
				monsterRepository.save(new Monster("Ultra Paradise", 8.99, MONSTER_ULTRA, 29, "https://marvel-b1-cdn.bc0a.com/f00000000104050/www.monsterenergy.com/media/uploads_image/2020/10/27/auto/800/6b88663a9bd7ed75cd00378dfefefaed.png?mod=v1_6172ae01be6402fa951732702161e15a"));
				monsterRepository.save(new Monster("Ultra Violet", 6.99, MONSTER_ULTRA, 98, "https://marvel-b1-cdn.bc0a.com/f00000000104050/www.monsterenergy.com/media/uploads_image/2019/07/23/auto/800/c342b9c1c9b9765f02c934f2acd9ba18.png?mod=v1_94b8bfed60a0e342eaf761646a5e72f9"));

				monsterRepository.save(new Monster("Mango Loco", 10.50, JUICE_MONSTER, 24, "https://marvel-b1-cdn.bc0a.com/f00000000104050/www.monsterenergy.com/media/uploads_image/2019/07/24/auto/800/0969ee00c049b46f4ade59a0ad4d1509.png?mod=v1_52199a625ef68991c599e94df0c39586"));
				monsterRepository.save(new Monster("KHAOS", 9.99, JUICE_MONSTER, 67, "https://marvel-b1-cdn.bc0a.com/f00000000104050/www.monsterenergy.com/media/uploads_image/2017/08/15/auto/800/4842f597e4d6d23d68c720627dac11ec.png?mod=v1_6b91badae88274b29248e949596e865b"));
				monsterRepository.save(new Monster("Pacific Punch", 9.99, JUICE_MONSTER, 12, "https://marvel-b1-cdn.bc0a.com/f00000000104050/www.monsterenergy.com/media/uploads_image/2021/11/05/auto/800/0563959ed58f6554b9695be80007122e.png?mod=v1_7753a465b39c12d22bf8ab3ca5398d31"));

				monsterRepository.save(new Monster("Dragon Ice Tea",  9.99, DRAGON_TEA, 2, "https://marvel-b1-cdn.bc0a.com/f00000000104050/www.monsterenergy.com/media/uploads_image/2020/05/28/auto/800/b2e94e967b1e8624de702fb70b1ef2a7.png?mod=v1_23febff6e91b5977d2514d2ff2033575"));
				monsterRepository.save(new Monster("Dragon Ice Tea Peach", 9.99, DRAGON_TEA, 12, "https://marvel-b1-cdn.bc0a.com/f00000000104050/www.monsterenergy.com/media/uploads_image/2021/11/05/auto/800/651a8e8d00126accf686a727d5277a7d.png?mod=v1_64ee9780e9a4ce4f9dbbdb885e892cb8"));
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(MonsterShopApplication.class, args);
	}

}
