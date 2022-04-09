package com.burak.teamroster.entity;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "player")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Player implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name= "surname")
    private String surname;

    @Column(name = "player_position")
    private PlayerPosition playerPosition;

}
