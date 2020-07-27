package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.Booking;
import ru.netology.domain.BookingComparator;
import ru.netology.repository.BookingRepository;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class BookingManagerTest {
    @Mock
    BookingRepository repository;
    @InjectMocks
    private BookingManager manager = new BookingManager();
    private Booking first = new Booking(1, 60870, "DME", "DPS", 38);
    private Booking second = new Booking(2, 72506, "DME", "DPS", 25);
    private Booking third = new Booking(3, 77650, "DME", "DPS", 45);
    private Booking fourth = new Booking(4, 136128, "SVO", "DPS", 25);

    @BeforeEach
    void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
    }

    @Test
    void shouldFindAllFlightsIfDestinationNotExist() {
        Booking[] returned = {first, second, third, fourth};
        doReturn(returned).when(repository).findAll();

        Booking[] actual = manager.findAll("VNU", "HCM");
        Booking[] expected = {};

        assertArrayEquals(expected, actual);

    }

    @Test
    void shouldFindFlightIfAirportExists() {
        Booking[] returned = {first, second, third, fourth};
        doReturn(returned).when(repository).findAll();

        Booking[] actual = manager.findAll("SVO", "DPS");
        Booking[] expected = {fourth};

        assertArrayEquals(expected, actual);

    }

    @Test
    void shouldFindFligthsIfMoreAirportsExist() {
        Booking[] returned = {first, second, third, fourth};
        doReturn(returned).when(repository).findAll();

        Booking[] actual = manager.findAll("DME", "DPS");
        Booking[] expected = {first, second, third};

        assertArrayEquals(expected, actual);

    }

    @Test
    void shouldFindFlightsIfSortingByTravelTime() {
        Booking[] returned = {first, second, third, fourth};
        doReturn(returned).when(repository).findAll();

        BookingComparator comparator = new BookingComparator();

        Booking[] actual = manager.findAll("DME", "DPS", comparator);
        Booking[] expected = {second, first, third};

        assertArrayEquals(expected, actual);
    }


}