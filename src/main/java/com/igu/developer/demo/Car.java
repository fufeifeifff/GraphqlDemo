package com.igu.developer.demo;

import io.leangen.graphql.annotations.GraphQLQuery;
import lombok.*;

import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Getter @Setter
@NoArgsConstructor
@ToString @EqualsAndHashCode
@Table(name = "car")
public class Car {
    @Id @GeneratedValue
    @GraphQLQuery(name = "id", description = "A car's id")
    private Long id;
    @GraphQLQuery(name = "name", description = "A car's name")
    private String name;
    @GraphQLQuery(name = "carType", description = "A car's carType")
    private Integer carType;
    @GraphQLQuery(name = "createdDate", description = "A car's createdDate")
    private String createdDate;
}