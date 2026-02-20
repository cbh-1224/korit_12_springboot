package com.korit12.cardatabase.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {
    // CrudRepository에 없는 메서드라면 여기에 정의 해야함
    // 쿼리는 접두사(findBy)로 시작해야하고 쿼리에 이용할 엔티티 클래스 필드를 정의해야합니다.

    List<Car> findByBrand(String brand);
    List<Car> findByColor(String color);
    List<Car> findByModelYear(int modelYear);

    List<Car> findByBrandAndModel(String brand, String model);
    List<Car> findByBrandOrColor(String brand, String color);

    List<Car> findByBrandOrderByModelYearAsc(String brand);

    @Query("select c from Car c where c.model = ?1")
    List<Car> findByModel(String model);

    @Query("select c from Car c where c.brand like %?1")
    List<Car> findByBrandEndWith(String brand);

}
