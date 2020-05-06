package com.alu.flowableSpringBoot.repository;

import com.alu.flowableSpringBoot.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author jairy
 * @date 2020/4/28
 */
@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    Person findByUsername(String username);
}