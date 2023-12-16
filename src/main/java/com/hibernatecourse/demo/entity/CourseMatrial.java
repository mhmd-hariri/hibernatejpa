package com.hibernatecourse.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(
        exclude = "course"
)
public class CourseMatrial {
    @Id
    @SequenceGenerator(
            name = "course_matrial_sequence",
            sequenceName = "course_matrial_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_matrial_sequence"
    )
    private Long courseMatrialId;
    private  String url;
    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(
            name = "course_Id",
            referencedColumnName = "courseId"
    )
    private  Course course;
}
