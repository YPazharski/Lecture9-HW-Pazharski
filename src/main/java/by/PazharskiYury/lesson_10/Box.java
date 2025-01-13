package by.PazharskiYury.lesson_10;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public final class Box<T extends Fruit> {

    public static final double COMPARE_WEIGHT_EPSILON = 0.00001;
    private final ArrayList<T> fruits = new ArrayList<>();
    private double weight = 0;

    /**
     * @param fruit fruit to add to the box. Must be the same fruit as the first one, otherwise it won't be added.
     * @return true if added, otherwise - false
     */
    public boolean tryAdd(@NotNull T fruit) {
        if (!fruits.isEmpty() && fruits.getFirst().getClass() != fruit.getClass()) {
            return false;
        }

        fruits.add(fruit);
        weight += fruit.getWeight();
        return true;
    }

    public boolean tryAdd(@NotNull Box<T> anotherBox) {
        if ((anotherBox.fruits.isEmpty())
                || (!fruits.isEmpty() && fruits.getFirst().getClass() != anotherBox.fruits.getFirst().getClass())) {
            return false;
        }

        fruits.addAll(anotherBox.fruits);
        anotherBox.fruits.clear();
        weight += anotherBox.weight;
        anotherBox.weight = 0;
        return true;
    }

    public double getWeight() {
        return weight;
    }

    public boolean compare(@NotNull Box<?> another) {
        return Math.abs(this.getWeight() - another.getWeight()) < COMPARE_WEIGHT_EPSILON;
    }

    @Override
    public String toString() {
        return "Box{" +
                "fruits=" + fruits +
                ", weight=" + weight +
                '}';
    }

}