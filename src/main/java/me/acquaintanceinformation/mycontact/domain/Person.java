package me.acquaintanceinformation.mycontact.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor// 인자가 없는 생성자
@AllArgsConstructor //생성할때 인자값이 있는 생성자
@RequiredArgsConstructor //    @GeneratedValue 자동으로 번호가 생성되니 값을 빼고 생성
public class Person {

    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private int age;

    private String hobby;

    private String bloodType;

    private String address;

    @ToString.Exclude
    private String phoneNumber;

    private LocalDate birthdy;

    private String job;


    public boolean equals(Object object) {

        if (object == null) {
            return false;
        }
        Person person = (Person) object;

        if (!person.getName().equals(this.getName())) {
            return false;
        }
        if (person.getAge() != this.getAge()) {
            return false;
        }
        return true;
    }
}