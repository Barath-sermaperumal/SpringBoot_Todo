package com.codewithbubblu.SPRING_BOOT_JPA.repository;

import com.codewithbubblu.SPRING_BOOT_JPA.model.Todos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodosRepository extends JpaRepository<Todos,Integer> {
}
