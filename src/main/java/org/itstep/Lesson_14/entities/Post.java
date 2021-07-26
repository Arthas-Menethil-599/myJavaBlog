package org.itstep.Lesson_14.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="posts")
public class Post extends BaseEntity {

    private String title;
    private String content;
    private Integer author;
    private Timestamp date;
}
