package com.korit12.cardatabase.domain;

import jakarta.persistence.*;
import lombok.*;


@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) // JPA용 기본 생성자
@RequiredArgsConstructor // 필수 필드 생성자
@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    private String brand;
    @NonNull
    private String model;
    @NonNull
    private String color;
    @NonNull
    private String registrationNumber;
    @NonNull
    private int modelYear;
    @NonNull
    private int price;

    @ManyToOne
    @JoinColumn(name = "owner")
    @NonNull
    private Owner owner;

}
