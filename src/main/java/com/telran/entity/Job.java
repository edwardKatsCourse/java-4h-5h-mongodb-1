package com.telran.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString

//@Entity
//@Table(name="JOB")
@Document(collection = "jobs")
public class Job { //find by id

    @Id
    private String id; //NoSQL -> id:String | SQL -> id:Long
    private String description;

    @Singular
    private List<String> languages;
    private Integer minYearsOfExperience;

    //embedded
    @DBRef(lazy = true)
    private CompanyDetails companyDetails; //0mb - 10mb

}

