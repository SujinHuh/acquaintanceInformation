package me.acquaintanceinformation.mycontact.repository;

import me.acquaintanceinformation.mycontact.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person,Long> {

}
