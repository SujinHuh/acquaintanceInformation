package me.acquaintanceinformation.mycontact.repository;

import me.acquaintanceinformation.mycontact.domain.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PersonRepositoryTest {

    @Autowired
    PersonRepository personRepository;


    @Test
    void crud() {

        Person person = new Person();

        person.setName("Sujin");
        person.setAge(27);
        person.setBloodType("B");

        personRepository.save(person);

        System.out.println(personRepository.findAll());

        List<Person> people = personRepository.findAll();

        assertThat(people.size()).isEqualTo(1);
        assertThat(people.get(0).getName()).isEqualTo("Sujin");
        assertThat(people.get(0).getAge()).isEqualTo(27);
        assertThat(people.get(0).getBloodType()).isEqualTo("B");
    }
}