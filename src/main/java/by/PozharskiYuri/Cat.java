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
        if (distance < 0) {
            throw new IllegalArgumentException("Distance can't be negative.");
        }

        System.out.println(getClass().getSimpleName() + "s can't swim.");
    }

}
