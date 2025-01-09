package by.PozharskiYuri;

import org.jetbrains.annotations.NotNull;

public class Main {

    public static void main(String[] args) {
        runAnimalsSportScenario();
        runCatsEatScenario();
    }

    /**
     * Runs console scenario to ensure that task 5 of homework is done OK. Lot of drama warning!
     */
    public static void runCatsEatScenario() {
        Cat[] cats = {
                new Cat("Abby", 1),
                new Cat("Barsik", 2),
                new Cat("Car+roline", 3),
                new Cat("Dendy", 4),
                new Cat("Ella", 5),
                new Cat("Freddy", 6)
        };

        System.out.println(System.lineSeparator() + "OUR CATS" + System.lineSeparator());
        printAnimals(cats);
        FoodPlate whitePlate = new FoodPlate(5);
        FoodPlate silverPlate = new FoodPlate(16);

        for (Cat cat: cats) {
            System.out.printf("%S'S INFO BEFORE AN ATTEMPT TO EAT:" + System.lineSeparator(), cat.getName());
            System.out.println(cat);
            System.out.printf("FOOD CONTAINERS' INFO BEFORE %S ATTEMPT TO EAT:" + System.lineSeparator(), cat.getName());
            System.out.printf("Food container #%d. Food remained: %d" + System.lineSeparator(), System.identityHashCode(whitePlate), whitePlate.getFood());
            System.out.printf("Food container #%d. Food remained: %d" + System.lineSeparator(), System.identityHashCode(silverPlate), silverPlate.getFood());
            System.out.println();
            cat.eat(silverPlate.getFood() > whitePlate.getFood() ? silverPlate : whitePlate);
            System.out.printf("%S'S INFO AFTER AN ATTEMPT TO EAT:" + System.lineSeparator(), cat.getName());
            System.out.println(cat);
            System.out.printf("FOOD CONTAINERS' INFO AFTER %S ATTEMPT TO EAT:" + System.lineSeparator(), cat.getName());
            System.out.printf("Food container #%d. Food remained: %d" + System.lineSeparator(), System.identityHashCode(whitePlate), whitePlate.getFood());
            System.out.printf("Food container #%d. Food remained: %d" + System.lineSeparator(), System.identityHashCode(silverPlate), silverPlate.getFood());
            System.out.println();
            System.out.println();
        }

        System.out.println("LETS REPLACE ALL REMAINED FOOD FROM ONE CONTAINER TO ANOTHER...");
        silverPlate.increaseFood(whitePlate.decreaseFood(whitePlate.getFood()));
        System.out.printf("Food container #%d. Food remained: %d" + System.lineSeparator(), System.identityHashCode(whitePlate), whitePlate.getFood());
        System.out.printf("Food container #%d. Food remained: %d" + System.lineSeparator(), System.identityHashCode(silverPlate), silverPlate.getFood());

        System.out.println("LETS TRY TO FEED REMAINED HUNGRY CATS...");
        for (Cat cat: cats) {
            if (!cat.isWellFed()) {
                System.out.printf("Hungry %s is trying to eat from container #%d with %d remained food..." + System.lineSeparator(), cat.getName(), System.identityHashCode(silverPlate), silverPlate.getFood());
                cat.eat(silverPlate);
            }
        }

        System.out.println("OUR PLATES NOW:");
        System.out.println();
        System.out.printf("Food container #%d. Food remained: %d" + System.lineSeparator(), System.identityHashCode(whitePlate), whitePlate.getFood());
        System.out.printf("Food container #%d. Food remained: %d" + System.lineSeparator(), System.identityHashCode(silverPlate), silverPlate.getFood());
        System.out.println(System.lineSeparator());
        System.out.println("OUR CATS NOW:");
        System.out.println();
        printAnimals(cats);
    }

    /**
     * Runs console scenario to ensure that tasks 1 - 4 of homework are done OK
     */
    public static void runAnimalsSportScenario() {
        Animal[] allAnimals = getAnimals();

        printAnimalsStaticInfoToConsole();

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

        System.out.println("\nLET'S GIVE NAMES TO UNNAMED ANIMALS AND COUNT ALL OF THEM AGAIN!!\n");
        giveNamesToAnimals(allAnimals);
        printAnimalsNames(allAnimals);
        printAnimals(allAnimals);
        printAnimalsStaticInfoToConsole();
    }

    public static void giveNamesToAnimals(Animal @NotNull ... animals) {
        String[] animalNames = {"Barsik", "Snezhok", "Pirozhok", "Rudy", "Rusty", "Ryzhik", "Aqua", "Bantik"};
        int i = 0;
        for (Animal animal : animals) {
            if (animal.getName() == null) {
                i %= animalNames.length;
                String name = animalNames[i];
                animal.setName(name);
                i++;
            }

        }
    }

    public static void printAnimalsStaticInfoToConsole() {
        System.out.printf(System.lineSeparator() + "%sS WERE CREATED: %d" + System.lineSeparator(), Animal.class.getSimpleName().toUpperCase(), Animal.getCreatedAnimalsCounter());
        System.out.printf(System.lineSeparator() + "%sS WERE CREATED: %d" + System.lineSeparator(), Cat.class.getSimpleName().toUpperCase(), Cat.getCreatedCatsCounter());
        System.out.printf(System.lineSeparator() + "%sS WERE CREATED: %d" + System.lineSeparator(), Dog.class.getSimpleName().toUpperCase(), Dog.getCreatedDogsCounter());
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

    public static void printAnimals(Animal @NotNull ... animals) {
        for (Animal animal : animals) {
            try {
                System.out.println(animal);
            } catch (NullPointerException e) {
                System.out.println("Oh! Seems no such an animal nearby.");
            }
        }

        System.out.println();
    }

    public static void printAnimalsNames(Animal @NotNull ... animals) {
        for (Animal animal : animals) {
            try {
                System.out.println(animal.getName());
            } catch (NullPointerException e) {
                System.out.println("Oh! Seems no such an animal nearby.");
            }
        }

        System.out.println();
    }

    public static void askAnimalsRun(double distance, Animal @NotNull ... animals) {
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

    public static void askAnimalsSwim(double distance, Animal @NotNull ... animals) {
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