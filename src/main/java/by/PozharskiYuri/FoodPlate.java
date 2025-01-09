package by.PozharskiYuri;

public class FoodPlate implements Eatable {

    private int food;

    public FoodPlate(int food) {
        if (food < 0) {
            throw new IllegalArgumentException("FoodPlate quantity can't be negative.");
        }

        this.food = food;
    }

    @Override
    public int decreaseFood(int foodDecrement) {
        if (foodDecrement < 0) {
            throw new IllegalArgumentException("Food decrement can't be negative.");
        }
        if (foodDecrement >= food) {
            foodDecrement = food;
            food = 0;
        } else {
            food -= foodDecrement;
        }

        return foodDecrement;
    }

    @Override
    public void increaseFood(int foodIncrement) {
        if (foodIncrement < 0) {
            throw new IllegalArgumentException("Food increment can't be negative.");
        }

        food += foodIncrement;
    }

    @Override
    public int getFood() {
        return food;
    }

    @Override
    public String toString() {
        return "FoodPlate{" +
                "food=" + food +
                '}';
    }
}
