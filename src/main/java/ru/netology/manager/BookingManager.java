package ru.netology.manager;

import ru.netology.domain.Booking;
import ru.netology.repository.BookingRepository;

import java.util.Arrays;

public class BookingManager {
    private BookingRepository repository;

    public BookingManager() {
    }

    public BookingManager(BookingRepository repository) {
        this.repository = repository;
    }

    public void add(Booking flight) {
        repository.save(flight);
    }

    public Booking[] findAll(String from, String to) {
        Booking[] flights = repository.findAll();
        Booking[] result = new Booking[0];

        for (Booking flight : flights) {
            if (from.equals(flight.getFrom()) &&
                    to.equals(flight.getTo())){
                int length = result.length + 1;
                Booking[] tmp = new Booking[length];
                System.arraycopy(result, 0, tmp, 0, result.length);
                int lastIndex = tmp.length - 1;
                tmp[lastIndex] = flight;
                result = tmp;
            }
        }

        Arrays.sort(result);

        return result;
    }


}
