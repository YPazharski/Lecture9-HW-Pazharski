package by.PozharskiYuri;

import java.util.Objects;
import java.util.StringJoiner;

public class Animal {

    private String name;

    public Animal() {

    }

    public Animal(String name) {
        this.name = name;
    }

    /**
     * @param distance run distance in meters.
     */
    public void run(double distance) {
        if (distance < 0) {
            throw new IllegalArgumentException("Distance can't be negative.");
        }

        System.out.printf("%s run %.2f meters.\n", name == null ? getClass().getName() : name, distance);
    }

    /**
     * @param distance swim distance in meters.
     */
    public void swim(double distance) {
        if (distance < 0) {
            throw new IllegalArgumentException("Distance can't be negative.");
        }

        System.out.printf("%s swam %.2f meters.\n", name == null ? getClass().getName() : name, distance);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return name != null && Objects.equals(name, animal.getName());
    }

    @Override
    public int hashCode() {
        return 137 * Objects.hashCode(name) ^ getClass().getName().hashCode();
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", getClass().getSimpleName() + " (", ")")
                .add("Name: " + (name == null ? "(no name)" : name))
                .toString();
    }
}
