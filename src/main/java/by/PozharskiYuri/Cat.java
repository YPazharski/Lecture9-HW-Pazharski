package by.PozharskiYuri;

public class Cat extends Animal {

    public static final double MAX_RUN_DISTANCE = 200; // value in meters

    public Cat() {

    }

    public Cat(String name) {
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
        if (distance < 0) {
            throw new IllegalArgumentException("Distance can't be negative.");
        }

        System.out.println(getClass().getSimpleName() + "s can't swim.");
    }

}
