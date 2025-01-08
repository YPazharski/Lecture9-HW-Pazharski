package by.PozharskiYuri;

import org.jetbrains.annotations.NotNull;

public class Main {

    public static void main(String[] args) {
        Animal[] allAnimals = getAnimals();

        System.out.printf(System.lineSeparator() + "%sS WERE CREATED: %d" + System.lineSeparator(), Animal.class.getSimpleName().toUpperCase(), Animal.getCreatedAnimalsCounter());
        System.out.printf(System.lineSeparator() + "%sS WERE CREATED: %d" + System.lineSeparator(), Cat.class.getSimpleName().toUpperCase(), Cat.getCreatedCatsCounter());
        System.out.printf(System.lineSeparator() + "%sS WERE CREATED: %d" + System.lineSeparator(), Dog.class.getSimpleName().toUpperCase(), Dog.getCreatedDogsCounter());

        System.out.println("\nOUR ANIMALS:\n");
        printAnimals(allAnimals);

        System.out.println("\nTHEIR NAMES:\n");
        printAnimalsNames(allAnimals);

        System.out.println("\nLET'S RUN 0 DISTANCE!\n");
        askAnimalsRun(0, allAnimals);

        System.out.println("\nLET'S RUN " + Cat.MAX_RUN_DISTANCE + " METERS!\n");
        askAnimalsRun(Cat.MAX_RUN_DISTANCE, allAnimals);

        System.out.println("\nLET'S RUN " + Dog.MAX_RUN_DISTANCE + " METERS!\n");
        askAnimalsRun(Dog.MAX_RUN_DISTANCE, allAnimals);

        double bigRunDistance = Dog.MAX_RUN_DISTANCE + Cat.MAX_RUN_DISTANCE + 1;
        System.out.println("\nLET'S RUN " + bigRunDistance + " METERS!\n");
        askAnimalsRun(bigRunDistance, allAnimals);

        System.out.println("\nLET'S RUN NEGATIVE DISTANCE!\n");
        askAnimalsRun(-1, allAnimals);

        System.out.println("\nLET'S SWIM 0 DISTANCE!\n");
        askAnimalsSwim(0, allAnimals);

        System.out.println("\nLET'S SWIM " + Dog.MAX_SWIM_DISTANCE + " METERS!\n");
        askAnimalsSwim(Dog.MAX_SWIM_DISTANCE, allAnimals);

        double bigSwimDistance = Dog.MAX_SWIM_DISTANCE + 1;
        System.out.println("\nLET'S SWIM " + bigSwimDistance + " METERS!\n");
        askAnimalsSwim(bigSwimDistance, allAnimals);

        System.out.println("\nLET'S SWIM NEGATIVE DISTANCE!\n");
        askAnimalsSwim(-1, allAnimals);
    }

    public static Animal @NotNull [] getAnimals() {
        Dog dog = new Dog();
        Dog namedDog = new Dog("Named Dog");
        Animal animalDog = new Dog("Animal Dog");

        Cat cat = new Cat(null, 1);
        Cat cat2 = new Cat(null, 2);
        Cat namedCat = new Cat("Named Cat", 3);
        Cat namedCat2 = new Cat("Tom", 5);
        Animal animalCat = new Cat("Animal Cat", 8);

        return new Animal[]{
                dog,
                namedDog,
                animalDog,
                cat,
                cat2,
                namedCat,
                namedCat2,
                animalCat
        };
    }

    public static void printAnimals(Animal... animals) {
        for (Animal animal : animals) {
            System.out.println(animal);
        }

        System.out.println();
    }

    public static void printAnimalsNames(Animal... animals) {
        for (Animal animal : animals) {
            System.out.println(animal.getName());
        }
    }

    public static void askAnimalsRun(double distance, @NotNull Animal... animals) {
        for (Animal animal : animals) {
            try {
                animal.run(distance);
            } catch (IllegalArgumentException e) {
                System.out.println("OOPS! " + e.getMessage());
            } catch (NullPointerException e) {
                System.out.println("Oh! Seems no such an animal nearby.");
            }
        }

        System.out.println();
    }

    public static void askAnimalsSwim(double distance, @NotNull Animal... animals) {
        for (Animal animal : animals) {
            try {
                animal.swim(distance);
            } catch (IllegalArgumentException e) {
                System.out.println("OOPS! " + e.getMessage());
            } catch (NullPointerException e) {
                System.out.println("Oh! Seems no such an animal nearby.");
            }
        }

        System.out.println();
    }

}