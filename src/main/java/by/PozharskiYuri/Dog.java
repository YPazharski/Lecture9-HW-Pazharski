package by.PozharskiYuri;

public class Dog extends Animal {

    public static final double MAX_RUN_DISTANCE = 500; // value in meters
    public static final double MAX_SWIM_DISTANCE = 10; // value in meters
    private static int createdDogsCounter;

    public Dog() {
        createdDogsCounter++;
    }

    public Dog(String name) {
        super(name);
        createdDogsCounter++;
    }

    /**
     * @param distance run distance in meters.
     */
    @Override
    public void run(double distance) {
        if (distance > MAX_RUN_DISTANCE) {
            String displayingName = getName() == null ? getClass().getSimpleName() : getName();
            System.out.printf("%s can't run more than %.2f meters." + System.lineSeparator(), displayingName, MAX_RUN_DISTANCE);
        } else {
            super.run(distance);
        }
    }

    /**
     * @param distance swim distance in meters.
     */
    @Override
    public void swim(double distance) {
        if (distance > MAX_SWIM_DISTANCE) {
            String displayingName = getName() == null ? getClass().getSimpleName() : getName();
            System.out.printf("%s can't swim more than %.2f meters.\n", displayingName, MAX_SWIM_DISTANCE);
        } else {
            super.swim(distance);
        }
    }

    public static int getCreatedDogsCounter() {
        return createdDogsCounter;
    }

}
