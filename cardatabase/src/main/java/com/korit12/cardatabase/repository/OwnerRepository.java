package com.korit12.cardatabase.repository;

import com.korit12.cardatabase.domain.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner, Long> {
}
