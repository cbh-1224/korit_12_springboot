package springboot.cardatabase00;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springboot.cardatabase00.domain.Car;
import springboot.cardatabase00.repository.CarRepository;
import springboot.cardatabase00.domain.Owner;
import springboot.cardatabase00.repository.OwnerRepository;


import java.util.Arrays;

@SpringBootApplication
public class Cardatabase00Application implements CommandLineRunner {
	private static final Logger logger = LoggerFactory.getLogger(Cardatabase00Application.class);

    public Cardatabase00Application(CarRepository carRepository, OwnerRepository ownerRepository) {
        this.carRepository = carRepository;
        this.ownerRepository = ownerRepository;
    }

    public static void main(String[] args) {
		SpringApplication.run(Cardatabase00Application.class, args);
		logger.info("애플리케이션이 실행됩니다.");
	}

	private final CarRepository carRepository;
	private final OwnerRepository ownerRepository;

	@Override
	public void run(String... args) throws Exception {
		Owner owner1 = new Owner("김", "일");
		Owner owner2 = new Owner("김", "이");
		ownerRepository.saveAll(Arrays.asList(owner1, owner2));
		carRepository.save(new Car("현대", "소나타", "검정", "123가4567", 2026, 35000000, owner1));
		carRepository.save(new Car("기아", "K5", "검정", "987나6543", 2025, 35000000, owner2));
		carRepository.save(new Car("현대", "그랜저", "흰색", "456다7890", 2024, 40000000, owner2));

	}
}
