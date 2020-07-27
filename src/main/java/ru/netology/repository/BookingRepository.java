package ru.netology.repository;

import ru.netology.domain.Booking;
import ru.netology.exception.NotFoundException;

public class BookingRepository {
    private Booking[] flights = new Booking[0];

    public Booking[] findAll(){
        return flights;
    }

    public void save(Booking flight) {
        int length = flights.length + 1;
        Booking[] tmp = new Booking[length];
        System.arraycopy(flights, 0, tmp, 0, flights.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = flight;
        flights = tmp;
    }

    public Booking findById(int id) {
        for (Booking flight : flights) {
            if (flight.getId() == id) {
                return flight;
            }
        }
        return null;
    }

    public void removeById(int id) {
        if (findById(id) == null) {
            throw new NotFoundException("Flight with id: " + id + " not found");
        }
        int length = flights.length - 1;
        Booking[] tmp = new Booking[length];
        int index = 0;
        for (Booking flight : flights) {
            if (flight.getId() != id) {
                tmp[index] = flight;
                index++;
            }
        }
        flights = tmp;
    }

    public void removeAll() {
        flights = new Booking[0];
    }
}
