package org.itstep.Lesson_14.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="users")
public class User extends BaseEntity{

    private String email;

    private String password;

    @Column(name="full_name")
    private String fullName;
}
