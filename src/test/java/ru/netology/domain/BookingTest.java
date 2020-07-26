package ru.netology.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BookingTest {
    private Booking first = new Booking(1, 60870, "DME", "DPS", 38);
    private Booking second = new Booking(2, 72506, "DME", "DPS", 25);
    private Booking third = new Booking(3, 77650, "DME", "DPS", 45);
    private Booking fourth = new Booking(4, 136128, "SVO", "DPS", 25);

    @Test
    public void shouldSortByPrice(){
        Booking[] expected = new Booking[]{first, second, third, fourth};
        Booking[] actual = new Booking[]{first, second, third, fourth};

        Arrays.sort(actual);

        assertArrayEquals(expected, actual);
    }

}