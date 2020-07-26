package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Booking {
    private int id;
    private int price;
    private String from;
    private String to;
    private int travelTime;

}
