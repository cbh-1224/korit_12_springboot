package com.korit12.cardatabase;

import com.korit12.cardatabase.domain.AppUser;
import com.korit12.cardatabase.domain.Car;
import com.korit12.cardatabase.repository.AppUserRepository;
import com.korit12.cardatabase.repository.CarRepository;
import com.korit12.cardatabase.domain.Owner;
import com.korit12.cardatabase.repository.OwnerRepository;
import lombok.AllArgsConstructor;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;

import java.util.Arrays;

@SpringBootApplication
@AllArgsConstructor
public class CardatabaseApplication implements CommandLineRunner {
	private static final Logger logger = LoggerFactory.getLogger(CardatabaseApplication.class);

    public static void main(String[] args) {
		SpringApplication.run(CardatabaseApplication.class, args);
		logger.info("애플리케이션이 실행됩니다.");
	}

	private final CarRepository carRepository;
	private final OwnerRepository ownerRepository;
	private final AppUserRepository appUserRepository;

	@Override
	public void run(String... args) throws Exception {
		Owner owner1 = new Owner("김","일");
		Owner owner2 = new Owner("김","이");
		ownerRepository.saveAll(Arrays.asList(owner1, owner2));
		carRepository.save(new Car("현대", "소나타", "검정", "123가4567", 2026, 30000000, owner1));
		carRepository.save(new Car("기아", "K9", "흰색", "987나5432", 2025, 20000000, owner2));
		carRepository.save(new Car("람보르기니", "쿤타치", "빨강", "159다7532", 2010, 100000000, owner2));

		appUserRepository.save(new AppUser("user", "$2a$12$awzJz2giiZeCYxYYzoVVQexCvXEQhF8dRXxHTxetNDqr.7DmaMwY6", "User"));
		appUserRepository.save(new AppUser("admin", "$2a$12$WfwqPAuaAO.MJiFMTk9D8ec0bmSihqVyiumUK7k7wYNxdbrRzKxji", "Admin"));
	}
}
