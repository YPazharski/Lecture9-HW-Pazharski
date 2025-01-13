package by.PazharskiYury.lesson_10;

public abstract class Fruit {

    public abstract double getWeight();

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}