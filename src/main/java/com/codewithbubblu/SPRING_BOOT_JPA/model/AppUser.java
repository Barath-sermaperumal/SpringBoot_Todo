package com.codewithbubblu.SPRING_BOOT_JPA.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AppUser {

    @Id
    @GeneratedValue
    private int id;
    private String email;
    private String password;

    @JsonIgnore
    @OneToMany(mappedBy = "appUser")
    private List<Todos> todolist;
}
