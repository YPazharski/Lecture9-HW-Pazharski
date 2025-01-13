package by.PazharskiYury.lesson_10;

import java.util.Arrays;

public class Lesson10Main {

    public static void main(String[] args) {
        String[] stringArray = new String[] {"1", "2"};
        ArrayElementsSwapper.swapArrayElements(stringArray, 0, 1);
        System.out.println(Arrays.toString(stringArray));
        Integer[] intArray = new Integer[] {1, 2, 3};
        ArrayElementsSwapper.swapArrayElements(intArray, 0, 2);
        System.out.println(Arrays.toString(intArray));
    }

}
