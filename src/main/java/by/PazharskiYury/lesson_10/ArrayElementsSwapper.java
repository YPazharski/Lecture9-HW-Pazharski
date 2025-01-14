package by.PazharskiYury.lesson_10;

import org.jetbrains.annotations.NotNull;

public class ArrayElementsSwapper {

    public static <T> void swapArrayElements(T @NotNull [] array, int firstIndex, int secondIndex) {
        T buffer = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = buffer;
    }

}