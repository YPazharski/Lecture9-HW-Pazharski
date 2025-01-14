package by.PazharskiYury.lesson_10;

import java.util.Arrays;

public class Lesson10Main {

    public static void main(String[] args) {
        String[] stringArray = new String[]{"1", "2"};
        ArrayElementsSwapper.swapArrayElements(stringArray, 0, 1);
        System.out.println(Arrays.toString(stringArray));
        Integer[] intArray = new Integer[]{1, 2, 3};
        ArrayElementsSwapper.swapArrayElements(intArray, 0, 2);
        System.out.println(Arrays.toString(intArray));

        Apple apple = new Apple();
        Orange orange = new Orange();
        Fruit fruitApple = new Apple();
        Fruit fruitOrange = new Orange();

        Box<Apple> appleBox = new Box<>();
        System.out.println(appleBox);

        System.out.println(apple);
        appleBox.tryAdd(apple);
        System.out.println(apple);
        System.out.println(appleBox);
        appleBox.tryAdd(new Apple());
        appleBox.tryAdd(new Apple());

        System.out.println(appleBox);

        Box<Orange> orangeBox = new Box<>();
        System.out.println(orangeBox);

        orangeBox.tryAdd(orange);
        orangeBox.tryAdd(new Orange());

        System.out.println(orangeBox);

        System.out.println(appleBox.compare(orangeBox));

        Box<Fruit> fruitBox = new Box<>();
        System.out.println(fruitBox);

        fruitBox.tryAdd(apple);
        fruitBox.tryAdd(fruitApple);
        if (fruitBox.tryAdd(orange)) {
            System.out.println("OOPS");
            return;
        }

        fruitBox.tryAdd(fruitOrange);

        System.out.println(fruitBox);

        Box<Fruit> fruitBox2 = new Box<>();
        System.out.println(fruitBox2);

        fruitBox2.tryAdd(fruitApple);
        System.out.println(fruitBox2);

        if (!fruitBox2.tryAdd(fruitBox)) {
            System.out.println("OOPS");
            return;
        }

        System.out.println(fruitBox2);
        System.out.println(fruitBox);
    }

}