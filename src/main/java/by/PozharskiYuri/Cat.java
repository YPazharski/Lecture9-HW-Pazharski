package by.PozharskiYuri;

import org.jetbrains.annotations.NotNull;

import java.util.StringJoiner;

public class Cat extends Animal {

    public static final double MAX_RUN_DISTANCE = 200; // value in meters
    private static int createdCatsCounter;
    private final int appetite;
    private boolean isWellFed;

    public Cat(String name, int appetite) {
        super(name);
        createdCatsCounter++;
        this.appetite = appetite;
    }

    public static int getCreatedCatsCounter() {
        return createdCatsCounter;
    }

    public void eat(@NotNull Eatable eatable) {
        if (!isWellFed && eatable.getFood() >= appetite) {
            eatable.decreaseFood(appetite);
            isWellFed = true;
        }
    }

    /**
     * @param distance run distance in meters.
     */
    @Override
    public void run(double distance) {
        if (distance > MAX_RUN_DISTANCE) {
            String displayingName = getName() == null ? getClass().getSimpleName() : getName();
            System.out.printf("%s can't run more than %.2f meters." + System.lineSeparator(), displayingName, MAX_RUN_DISTANCE);
        } else {
            isWellFed = false;
            super.run(distance);
        }
    }

    /**
     * @param distance swim distance in meters.
     */
    @Override
    public void swim(double distance) {
        if (distance < 0) {
            throw new IllegalArgumentException("Distance can't be negative.");
        }

        System.out.println(getName() + " does not want to swim.");
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", getClass().getSimpleName() + " (", ")")
                .add("Name: " + (getName() == null ? "(no name)" : getName()))
                .add("Appetite: " + appetite)
                .add("Is well fed: " + isWellFed)
                .toString();
    }

    public boolean isWellFed() {
        return isWellFed;
    }

}
