package com.haihaycode.java5.lab6.model;

import com.haihaycode.java5.lab5.entity.Category;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Report {
    Category group;
    Double sum;
    Long count;

    public Report(Category group, Double sum, Long count) {
        this.group = group;
        this.sum = sum;
        this.count = count;
    }
}