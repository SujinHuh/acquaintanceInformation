package me.acquaintanceinformation.mycontact.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@ToString
public class Person {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private int age;

    private String hobby;

    private String bloodType;

    private String address;

    @ToString.Exclude
    private String phoneNumber;

    private LocalDate birthdy;

    private String job;

}
