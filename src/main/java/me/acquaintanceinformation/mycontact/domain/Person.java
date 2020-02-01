package me.acquaintanceinformation.mycontact.domain;

import lombok.*;
import me.acquaintanceinformation.mycontact.domain.dto.Birthday;

import javax.persistence.*;
import javax.validation.Valid;

@Entity
@NoArgsConstructor// 인자가 없는 생성자
@AllArgsConstructor //생성할때 인자값이 있는 생성자
@RequiredArgsConstructor //    @GeneratedValue 자동으로 번호가 생성되니 값을 빼고 생성z
@Data
public class Person {

    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private int age;

    private String hobby;
    @NonNull
    private String bloodType;

    private String address;

    @ToString.Exclude
    private String phoneNumber;

    @Valid
    @Embedded
    private Birthday birthday;

    private String job;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private Block block;
}