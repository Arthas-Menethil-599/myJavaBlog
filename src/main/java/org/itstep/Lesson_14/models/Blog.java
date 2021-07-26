package org.itstep.Lesson_14.models;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Blog {

    private Integer id;

    private String title;

    private String content;

    private String fullName;
}
