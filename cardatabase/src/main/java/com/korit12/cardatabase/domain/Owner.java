package com.korit12.cardatabase.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@NoArgsConstructor (access = AccessLevel.PROTECTED)
@RequiredArgsConstructor
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ownerId;

    @Setter @NonNull
    private String firstName;
    @Setter @NonNull
    private String lastName;

    @OneToMany(cascade = CascadeType.ALL,  mappedBy = "owner")
    @Setter
    private List<Car> cars;

}
