package by.PozharskiYuri;

public class Animal {

    private final String name;

    public Animal(String name) {
        this.name = name;
    }

    public void run(double distance) {
        if (distance < 0) {
            throw new IllegalArgumentException("Distance can't be negative.");
        }

        System.out.printf("%s пробежал(-а) %.2f метров.\n", name, distance);
    }

    public void swim(double distance) {
        if (distance < 0) {
            throw new IllegalArgumentException("Distance can't be negative.");
        }

        System.out.printf("%s проплыл(-а) %.2f метров.\n", name, distance);
    }

    public String getName() {
        return name;
    }

}
