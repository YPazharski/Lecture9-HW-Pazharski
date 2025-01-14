package by.PazharskiYury.lesson_10;

public abstract class Fruit {

    public abstract double getWeight();

    private boolean isBoxed = false;

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + '{' +
                "isBoxed=" + isBoxed +
                '}';
    }

    public boolean isBoxed() {
        return isBoxed;
    }

    protected void setBoxed() {
        isBoxed = true;
    }

}