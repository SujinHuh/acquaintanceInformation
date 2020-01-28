package me.acquaintanceinformation.mycontact.repository;

import me.acquaintanceinformation.mycontact.domain.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
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

    @Test
    void allArgsConstructor() {
        Person person = new Person(1l,"Sujin",10,"reading","B","Seoul","010-9053-", LocalDate.of(2020,1,1),"programer");
    }

    @Test
    void constructor() {

        Person person = new Person("Sujin",20);
    }

    @Test
    void hashCodeEquals() {

        Person personOne = new Person("Sujin",30);
        Person personTwo = new Person("Sujin",30);

        System.out.println(personOne.equals(personTwo));
        System.out.println(personOne.hashCode());
        System.out.println(personTwo.hashCode());
    }
}