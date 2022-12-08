package com.example.transaction.User;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

}
