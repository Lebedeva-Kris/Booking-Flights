package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Booking;
import ru.netology.exception.NotFoundException;
import ru.netology.manager.BookingManager;

import static org.junit.jupiter.api.Assertions.*;

class BookingRepositoryTest {
    private BookingRepository repository = new BookingRepository();

    private BookingManager manager = new BookingManager();
    private Booking first = new Booking(1, 60870, "DME", "DPS", 38);
    private Booking second = new Booking(2, 72506, "DME", "DPS", 25);
    private Booking third = new Booking(3, 77650, "DME", "DPS", 45);
    private Booking fourth = new Booking(4, 136128, "SVO", "DPS", 25);

    @BeforeEach
    void setUp() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
    }

    @Test
    void shouldFindAll() {
        Booking[] expected = {first, second, third, fourth};
        Booking[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindByIdIfExist() {
        int idToFind = 3;

        Booking expected = third;
        Booking actual = repository.findById(idToFind);

        assertEquals(expected, actual);
    }

    @Test
    void shouldFindByIdIfNotExist() {
        int idToFind = 5;

        Booking actual = repository.findById(idToFind);

        assertNull(actual);
    }

    @Test
    void shouldRemoveByIdIfExist() {
        int idToRemove = 2;

        repository.removeById(idToRemove);

        Booking[] expected = {first, third, fourth};
        Booking[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByIdIfNotExist() {
        assertThrows(NotFoundException.class, () -> repository.removeById(5));
    }


    @Test
    void shouldRemoveAllFlights() {
        repository.removeAll();

        Booking[] expected = {};
        Booking[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }


}