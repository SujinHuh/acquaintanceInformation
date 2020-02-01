package me.acquaintanceinformation.mycontact.service;

import me.acquaintanceinformation.mycontact.domain.Block;
import me.acquaintanceinformation.mycontact.domain.Person;
import me.acquaintanceinformation.mycontact.repository.BlockRepository;
import me.acquaintanceinformation.mycontact.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PersonServiceTest {

    @Autowired
    private PersonService personService;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private BlockRepository blockRepository;


    @Test
    void getPeopleExcludeBlock() {
        givenPeople();

        List<Person> result = personService.getPeopleExcludeBlock();

        result.forEach(System.out::println);
    }

    @Test
    void cascadeTest() {
        givenPeople();

        List<Person> result = personRepository.findAll();

        Person person = result.get(3);
        person.getBlock().setStartDate(LocalDate.now());
        person.getBlock().setEndDate(LocalDate.now());

        personRepository.save(person);
        personRepository.findAll().forEach(System.out::println);
//        System.out.println("====delete===");
//        personRepository.delete(person);
//        personRepository.findAll().forEach(System.out::println);
//        System.out.println("====BlockRepository===");
//        blockRepository.findAll().forEach(System.out::println);
        System.out.println();
        person.setBlock(null);
        personRepository.save(person);
        personRepository.findAll().forEach(System.out::println);
        blockRepository.findAll().forEach(System.out::println);
    }

    private void givenPeople() {

        givenPerson("sujin", 10, "B");
        givenBlockPerson("abge", 20, "A");
        givenPerson("noq", 9, "O");
        givenBlockPerson("sujin", 11, "AB");
    }

    @Test
    void getPerson() {
        givenPeople();

        Person person = personService.getPerson(4L);

        System.out.println(person);
    }

    private void givenPerson(String name, int age, String bloodType) {
        personRepository.save(new Person(name, age, bloodType));
    }

    private void givenBlockPerson(String name, int age, String bloodType) {
        Person blockPerson = new Person(name, age, bloodType);
        blockPerson.setBlock(new Block());

        personRepository.save(blockPerson);
    }


}