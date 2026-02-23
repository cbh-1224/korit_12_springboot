package springboot.cardatabase00.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springboot.cardatabase00.domain.Owner;

public interface OwnerRepository extends JpaRepository<Owner, Long> {
}
