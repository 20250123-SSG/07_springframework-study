package com.ibe6.di.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Phone {
    private String name;
    private String brand;
    private int price;
    private String releaseDate;
}