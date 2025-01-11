package by.PozharskiYuri;

import org.jetbrains.annotations.NotNull;

import java.time.LocalTime;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        runAnimalsSportScenario();
        runCatsEatScenario();
        runPaymentScenario();
        runParkScenario();
    }

    /**
     * Runs short console scenario to ensure that task 7 of homework is done OK.
     */
    public static void runParkScenario() {
        System.out.println();
        Park myPark = new Park("myPark", "Raccoon city", LocalTime.of(10, 0), LocalTime.of(22, 0));
        Park notMyPark = new Park("NotMyPark", "Somewhere", LocalTime.MIDNIGHT, LocalTime.NOON);
        Park.Attraction firstAttraction = myPark.new Attraction("Attraction1", 12);
        System.out.println(myPark);
        myPark.setWorkTime(LocalTime.of(9, 0), LocalTime.of(23, 0));
        System.out.println(myPark);
        List<Park.Attraction> myAttractions = myPark.getAttractions();
        myAttractions.getFirst().setWorkTime(LocalTime.of(12, 0), LocalTime.of(17, 0));
        //myAttractions.add(notMyPark.new Attraction("ZeroAttraction", 55));  //Won't work... As expected
        Park.Attraction secondAttraction = myPark.new Attraction("Second attraction", 65, "Some", LocalTime.of(10, 1), LocalTime.of(16, 0));
        System.out.println(myPark);
    }

    /**
     * Runs console scenario to ensure that task 6 of homework is done OK.
     */
    public static void runPaymentScenario() {
        System.out.println();
        Wallet myWallet = new Wallet("MyWallet", 300);
        Payment myPayment = new Payment(myWallet);
        System.out.println(myPayment);
        Payment.Item bread = myPayment.new Item("2x Bread", 3);
        Payment.Item butter = myPayment.new Item("Butter", 5);
        Payment.Item pants = myPayment.new Item("Pants", 40);
        Payment.Item catFood = myPayment.new Item("Cat food 10 kg", 199.99);
        System.out.println(myPayment);
        tryToPay(bread);
        tryToPay(bread);
        tryToPay(butter);
        tryToPay(pants);
        tryToPay(catFood);
        System.out.println(myPayment);
        Payment.Item bike = myPayment.new Item("Bike", 999.99);
        tryToPay(bike);
        System.out.println(myPayment);
        myWallet.increaseBalance(1000);
        System.out.println(myWallet);
        System.out.println(bike);
        while (catFood.pay()) {
            System.out.println("Take care of cats!");
        }

        System.out.println(myPayment);
    }

    public static void tryToPay(Payment.@NotNull Item item) {
        if (!item.pay()) {
            System.out.printf(System.lineSeparator() + "Sorry you could not buy that %s. %s's price: %.2f." + System.lineSeparator(),
                    item.getDescription(), item.getDescription(), item.getPrice());
        }

    }

    /**
     * Runs console scenario to ensure that task 5 of homework is done OK. Lot of drama warning!
     */
    public static void runCatsEatScenario() {
        System.out.println();
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

        for (Cat cat : cats) {
            System.out.printf("%S'S INFO BEFORE AN ATTEMPT TO EAT:" + System.lineSeparator(), cat.getName());
            System.out.println(cat);
            System.out.printf("FOOD CONTAINERS' INFO BEFORE %S ATTEMPT TO EAT:" + System.lineSeparator(), cat.getName());
            printEatablesToConsole(whitePlate, silverPlate);
            System.out.println();
            cat.eat(silverPlate.getFood() > whitePlate.getFood() ? silverPlate : whitePlate);
            System.out.printf("%S'S INFO AFTER AN ATTEMPT TO EAT:" + System.lineSeparator(), cat.getName());
            System.out.println(cat);
            System.out.printf("FOOD CONTAINERS' INFO AFTER %S ATTEMPT TO EAT:" + System.lineSeparator(), cat.getName());
            printEatablesToConsole(whitePlate, silverPlate);
            System.out.println();
            System.out.println();
        }

        System.out.println("LETS REPLACE ALL REMAINED FOOD FROM ONE CONTAINER TO ANOTHER...");
        silverPlate.increaseFood(whitePlate.decreaseFood(whitePlate.getFood()));
        printEatablesToConsole(whitePlate, silverPlate);
        System.out.println();
        System.out.println("LETS TRY TO FEED REMAINED HUNGRY CATS...");

        for (Cat cat : cats) {
            if (!cat.isWellFed()) {
                System.out.printf("Hungry %s is trying to eat from container #%d with %d remained food..." + System.lineSeparator(), cat.getName(), System.identityHashCode(silverPlate), silverPlate.getFood());
                cat.eat(silverPlate);
            }
        }

        System.out.println();
        System.out.println("OUR PLATES NOW:");
        System.out.println();
        printEatablesToConsole(whitePlate, silverPlate);
        System.out.println(System.lineSeparator());
        System.out.println("OUR CATS NOW:");
        System.out.println();
        printAnimals(cats);
    }

    public static void printEatablesToConsole(Eatable @NotNull ... eatables) {
        for (Eatable eatable : eatables) {
            try {
                System.out.printf("Food container #%d. Food remained: %d" + System.lineSeparator(), System.identityHashCode(eatable), eatable.getFood());
            } catch (NullPointerException e) {
                System.out.println("Oh! Seems no such a food container nearby.");
            }
        }
    }

    /**
     * Runs console scenario to ensure that tasks 1 - 4 of homework are done OK
     */
    public static void runAnimalsSportScenario() {
        System.out.println();
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
            if (animal == null) {
                continue;
            }

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