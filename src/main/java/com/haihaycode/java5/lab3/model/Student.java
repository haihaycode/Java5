package com.haihaycode.java5.lab3.model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @NotBlank(message = "{NotBlank.student.name}")
    private String name;

    @NotBlank(message = "{NotBlank.student.email}")
    @Email(message = "{Email.student.email}")
    private String email;

    @NotNull(message = "{NotNull.student.marks}")
    @Min(value = 0, message = "{Min.student.marks}")
    @Max(value = 10, message = "{Max.student.marks}")
    private Double marks;

    @NotNull(message = "{NotNull.student.gender}")
    private Boolean gender;

    @NotBlank(message = "{NotBlank.student.faculty}")
    private String faculty;

    @NotEmpty(message = "{NotEmpty.student.hobbies}")
    private List<String> hobbies;

    private String avatarUrl;

}
