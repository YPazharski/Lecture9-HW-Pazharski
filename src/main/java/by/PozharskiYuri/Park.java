package by.PozharskiYuri;

import org.jetbrains.annotations.NotNull;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Park {

    private String name;
    private String address;
    private LocalTime openingTime;
    private LocalTime closingTime;
    private LocalTime minAttractionStartTime = LocalTime.MAX;
    private LocalTime maxAttractionFinishTime = LocalTime.MIN;
    private final List<Attraction> attractions = new ArrayList<>();

    public Park(@NotNull String name, @NotNull String address, @NotNull LocalTime openingTime, @NotNull LocalTime closingTime) {
        setWorkTime(openingTime, closingTime);
        this.name = name;
        this.address = address;
    }

    @NotNull
    public String getName() {
        return name;
    }

    public void rename(@NotNull String newName) {
        name = newName;
    }

    @NotNull
    public String getAddress() {
        return address;
    }

    public void moveTo(@NotNull String newAddress) {
        address = newAddress;
    }

    @NotNull
    public LocalTime getOpeningTime() {
        return openingTime;
    }

    @NotNull
    public LocalTime getClosingTime() {
        return closingTime;
    }

    public void setWorkTime(@NotNull LocalTime openingTime, @NotNull LocalTime closingTime) {
        if (openingTime.isAfter(closingTime) || openingTime.equals(closingTime) || openingTime.isAfter(minAttractionStartTime)) {
            throw new IllegalArgumentException("Opening time cant be after closing time, be equal to it, after the earliest attraction starts.");
        }

        if (closingTime.isBefore(maxAttractionFinishTime)) {
            throw new IllegalArgumentException("Closing time cant be before the most late attraction finishes.");
        }

        this.openingTime = openingTime;
        this.closingTime = closingTime;
    }

    public List<Attraction> getAttractions() {
        return Collections.unmodifiableList(attractions);
    }

    private void updateMinMaxAttractionTimes() {
        LocalTime min = LocalTime.MAX;
        LocalTime max = LocalTime.MIN;

        for (Attraction attraction : attractions) {
            if (attraction.startTime.isBefore(min)) {
                min = attraction.startTime;
            }

            if (attraction.finishTime.isAfter(max)) {
                max = attraction.finishTime;
            }
        }

        minAttractionStartTime = min;
        maxAttractionFinishTime = max;
    }

    @Override
    public String toString() {
        return "Park{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", openingTime=" + openingTime +
                ", closingTime=" + closingTime +
                ", attractions=" + attractions +
                '}';
    }

    public class Attraction {

        private String name;
        private double ticketPrice;
        private String description = "No description";
        private LocalTime startTime;
        private LocalTime finishTime;

        public Attraction(@NotNull String name, double ticketPrice) {
            initializeWorkTime(openingTime, closingTime);
            this.name = name;
            setTicketPrice(ticketPrice);
            attractions.add(this);
        }

        public Attraction(@NotNull String name, double ticketPrice, @NotNull String description) {
            this(name, ticketPrice);
            this.description = description;
        }

        public Attraction(@NotNull String name, double ticketPrice, @NotNull String description, @NotNull LocalTime startTime, @NotNull LocalTime finishTime) {
            initializeWorkTime(startTime, finishTime);
            this.name = name;
            setTicketPrice(ticketPrice);
            this.description = description;
            attractions.add(this);
        }

        @NotNull
        public String getName() {
            return name;
        }

        public void rename(@NotNull String newName) {
            this.name = name;
        }

        public double getTicketPrice() {
            return ticketPrice;
        }

        public void setTicketPrice(double ticketPrice) {
            if (ticketPrice < 0) {
                throw new IllegalArgumentException("Ticket price can not be negative!");
            }

            this.ticketPrice = ticketPrice;
        }

        @NotNull
        public String getDescription() {
            return description;
        }

        public void setDescription(@NotNull String description) {
            this.description = description;
        }

        @NotNull
        public LocalTime getStartTime() {
            return startTime;
        }

        @NotNull
        public LocalTime getFinishTime() {
            return finishTime;
        }

        private void initializeWorkTime(@NotNull LocalTime startTime, @NotNull LocalTime finishTime) {
            if (startTime.isAfter(finishTime) || startTime.equals(finishTime) || startTime.isBefore(openingTime)) {
                throw new IllegalArgumentException("Start time can't be before finish time nor equal to it nor before the time the park opens");
            }

            if (finishTime.isAfter(closingTime)) {
                throw new IllegalArgumentException("Finish time can't be after the park closes");
            }

            minAttractionStartTime = startTime.isBefore(minAttractionStartTime) ? startTime : minAttractionStartTime;
            maxAttractionFinishTime = finishTime.isAfter(maxAttractionFinishTime) ? finishTime : maxAttractionFinishTime;
            this.startTime = startTime;
            this.finishTime = finishTime;
        }

        public void setWorkTime(@NotNull LocalTime startTime, @NotNull LocalTime finishTime) {
            initializeWorkTime(startTime, finishTime);
            updateMinMaxAttractionTimes();
        }

        @Override
        public String toString() {
            return "Attraction{" +
                    "name='" + name + '\'' +
                    ", ticketPrice=" + ticketPrice +
                    ", description='" + description + '\'' +
                    ", startTime=" + startTime +
                    ", finishTime=" + finishTime +
                    '}';
        }
    }

}
