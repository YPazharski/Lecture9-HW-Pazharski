package by.PozharskiYuri;

public class Dog extends Animal {

    public static final double MAX_RUN_DISTANCE = 500; // value in meters
    public static final double MAX_SWIM_DISTANCE = 10; // value in meters

    public Dog() {

    }

    public Dog(String name) {
        super(name);
    }

    /**
     * @param distance run distance in meters.
     */
    @Override
    public void run(double distance) {
        String displayingName = getName() == null ? getClass().getSimpleName() : getName();

        if (distance < 0) {
            throw new IllegalArgumentException("Distance can't be negative.");
        } else if (distance > MAX_RUN_DISTANCE) {
            System.out.println(displayingName + " can't run more than " + MAX_RUN_DISTANCE + " meters.");
        } else {
            System.out.println(displayingName + " run " + distance + " meters.");
        }
    }

    /**
     * @param distance swim distance in meters.
     */
    @Override
    public void swim(double distance) {
        String displayingName = getName() == null ? getClass().getSimpleName() : getName();

        if (distance < 0) {
            throw new IllegalArgumentException("Distance can't be negative.");
        } else if (distance > MAX_SWIM_DISTANCE) {
            System.out.println(displayingName + " can't swim more than " + MAX_SWIM_DISTANCE + " meters.");
        } else {
            System.out.println();
        }
    }

}
