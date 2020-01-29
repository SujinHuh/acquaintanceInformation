package me.acquaintanceinformation.mycontact.service;

import me.acquaintanceinformation.mycontact.domain.Block;
import me.acquaintanceinformation.mycontact.domain.Person;
import me.acquaintanceinformation.mycontact.repository.BlockRepository;
import me.acquaintanceinformation.mycontact.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
        givenBlock();

        List<Person> result = personService.getPeopleExcludeBlock();
//        System.out.println(result);

        result.forEach(System.out::println);
    }


    private void givenPeople() {

        givenPerson("sujin", 10, "B");
        givenblockPerson("abge", 20, "A");
        givenPerson("noq", 9, "O");
        givenblockPerson("sujin", 11, "AB");
    }

    private void givenBlock() {
        givenBlock("sujin");
    }


    private void givenPerson(String name, int age, String bloodType) {
        personRepository.save(new Person(name, age, bloodType));
    }

    private void givenblockPerson(String name, int age, String bloodType) {
        Person blockPerson = new Person(name, age, bloodType);
        blockPerson.setBlock(givenBlock(name));

        personRepository.save(blockPerson);
    }

    private Block givenBlock(String name) {
        return blockRepository.save(new Block(name));

    }

}