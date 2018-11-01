package com.igu.developer.demo;

import lombok.*;

import java.util.Date;


@Data
public class CarVo{

    private @NonNull Long id;
    private @NonNull String name;
    private @NonNull Integer carType;
    private @NonNull Date createdDate;
}