package me.acquaintanceinformation.mycontact.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class Person {

    @Id @GeneratedValue
    private Long id;

    @Getter @Setter
    private String name;

    @Getter @Setter
    private int age;

    @Getter @Setter
    private String hobby;

    @Getter @Setter
    private String bloodType;

    @Getter @Setter
    private String address;

    @Getter @Setter
    private LocalDate birthdy;

    @Getter @Setter
    private String job;

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
