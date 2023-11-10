package com.codewithbubblu.SPRING_BOOT_JPA.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Todos {

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="userid",referencedColumnName = "id")
    private AppUser appUser;

    @Id
    @GeneratedValue
    private int id;
    private String todo;
}
