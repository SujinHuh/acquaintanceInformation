package me.acquaintanceinformation.mycontact.repository;

import me.acquaintanceinformation.mycontact.domain.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PersonRepositoryTest {

    @Autowired
    PersonRepository personRepository;

    private void givenPerson(String name, int age,String bloodType) {
        Person person = new Person(name, age,bloodType);
    }

    private void givenPerson(String name, int age, String bloodType,LocalDate birthday) {
        Person person = new Person(name, age, bloodType);
        person.setBirthdy(birthday);

        personRepository.save(person);
    }


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
//        Person person = new Person(1l,"Sujin",10,"reading","B","Seoul","010-9053-", LocalDate.of(2020,1,1),"programer");
    }

    @Test
    void constructor() {

//        Person person = new Person("Sujin",20);
    }

    @Test
    void hashCodeEquals() {

        Person personOne = new Person("Sujin", 30, "A");
        Person personTwo = new Person("Sujin", 30, "A");

        System.out.println(personOne.equals(personTwo));
        System.out.println(personOne.hashCode());
        System.out.println(personTwo.hashCode());

        Map<Person, Integer> map = new HashMap<>();
        map.put(personOne, personOne.getAge());


        System.out.println(map);
        System.out.println(map.get(personTwo));
    }


    @Test
    void findByBloodType() {

        givenPerson("sujin", 10, "B");
        givenPerson("abge", 20, "A");
        givenPerson("noq", 9, "O");
        givenPerson("sujin", 11, "AB");

       List <Person> result = personRepository.findByBloodType("B");


       result.forEach(System.out::println);

    }



    @Test
    void findByBirthdatBetween() {
        givenPerson("sujin", 10, "B",LocalDate.of(1994,12,20));
        givenPerson("martin", 9, "A",LocalDate.of(1992,7,20));
        givenPerson("minchi", 11, "AB",LocalDate.of(1993,1,5));
        givenPerson("sopia", 15, "B",LocalDate.of(1994,2,28));
        givenPerson("Jon", 15, "B",LocalDate.of(1995,12,29));
        List<Person> result = personRepository.findByBirthdyBetween(LocalDate.of(199,12,20), LocalDate.of(1995,12,29));

        result.forEach(System.out::println);
    }
}