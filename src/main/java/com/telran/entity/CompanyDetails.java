package com.telran.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Document(collection = "companyDetails")
public class CompanyDetails {

    @Id
    private String id;

    @Field(name = "company_name")
    @Indexed(unique = true)
    private Object companyName; //String, List, Map, int[]
    //Map<company name, company id >

    private String companyDescription;
    private String companyCity;
    private Integer startedSinceYear;
}
