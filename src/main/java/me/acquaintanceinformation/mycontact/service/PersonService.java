package me.acquaintanceinformation.mycontact.service;

import lombok.extern.slf4j.Slf4j;
import me.acquaintanceinformation.mycontact.domain.Block;
import me.acquaintanceinformation.mycontact.domain.Person;
import me.acquaintanceinformation.mycontact.repository.BlockRepository;
import me.acquaintanceinformation.mycontact.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private BlockRepository blockRepository;

    public List<Person> getPeopleExcludeBlock() {
        return personRepository.findByBlockIsNull();
    }

    public List<Person> getPeopleByName(String name) {

        return personRepository.findByName(name);
    }

    @Transactional(readOnly = true)
    public Person getPerson(Long id) {
        Person person = personRepository.findById(id).get();

//        System.out.println("person : "+ person);
        log.info("person :{}", person);

        return person;
    }
}
